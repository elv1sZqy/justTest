package com.tsu.zqy.poi;

import com.tsu.zqy.redisAndMybatis.pojo.Analyze;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExcelUtil
 * @Author Elv1s
 * @Date 2020/2/7 14:30
 * @Description:
 */
@Component
public class ExcelUtil {
    public static void main(String[] args) {

        ExcelUtil excelTest = new ExcelUtil();

        Workbook wb = excelTest.getExcel("C:\\Users\\NewB1\\Desktop\\所得税收入分析.xlsx");

        if (wb == null)
            System.out.println("文件读入出错");
        else {
            excelTest.analyzeExcel(wb);
        }

    }

    public Workbook getExcel(String filePath) {
        Workbook wb = null;
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("文件不存在");
            wb = null;
        } else {
            //获得后缀名
            String fileType = filePath.substring(filePath.lastIndexOf("."));
            try {
                InputStream is = new FileInputStream(filePath);
                if (".xls".equals(fileType)) {
                    wb = new HSSFWorkbook(is);
                } else if (".xlsx".equals(fileType)) {
                    wb = new XSSFWorkbook(is);
                } else {
                    System.out.println("格式不正确");
                    wb = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return wb;
    }

    public List<Analyze> analyzeExcel(Workbook wb) {
        List<Analyze> analyzes = new ArrayList<>();
        //读取sheet(从0计数)
        Sheet sheet = wb.getSheetAt(0);
        //读取行数(从0计数)
        int rowNum = sheet.getLastRowNum();
        for (int i = 1; i <= rowNum; i++) {
            //获得行
            Row row = sheet.getRow(i);
            //获得当前行的列数
            int colNum = row.getLastCellNum();
            Analyze analyze = new Analyze();
            for (int j = 0; j < colNum; j++) {
                //获取单元格
                Cell cell = row.getCell(j);
                if (cell == null) {
                    System.out.println("数据为空");
                } else {
                    if (cell.toString() == null || cell.toString().equals("")) {
                        continue;
                    }
                    switch (j) {
                        case 0:
                            analyze.setOpenTime(cell.toString());
                            break;
                        case 1:
                            analyze.setIncome(Double.parseDouble(cell.toString()));
                            break;
                        case 2:
                            analyze.setCost(cell.toString());
                            break;
                        case 3:
                            analyze.setPeopleSize(Integer.parseInt(cell.toString()));
                            break;
                        case 4:
                            analyze.setCount(Integer.parseInt(cell.toString()));
                            break;
                        case 5:
                            analyze.setTotalMoney(cell.toString());
                            break;
                        case 6:
                            analyze.setProjectName(cell.toString());
                            break;
                        case 8:
                            analyze.setCategoryName(cell.toString());
                            break;
                        case 7:
                            analyze.setIndustryName(cell.toString());
                            break;
                        default:
                            analyze.setStreetName(cell.toString());

                    }
                }
            }
            analyzes.add(analyze);
            /*if (!StringUtils.isEmpty(analyze.getCategoryName())&&!StringUtils.isEmpty(analyze.getIndustryName())&&!StringUtils.isEmpty(analyze.getStreetName())) {
                analyzes.add(analyze);
            }*/
        }
        return analyzes;
    }

}

package com.tsu.zqy.leetCode.stepone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Test_37
 * @Author Elv1s
 * @Date 2020/9/20 15:06
 * @Description:
 */
public class Test_37 {
    // 用两个Map表示行和列
    private static HashMap<Integer, List<String>> column = new HashMap<>();
    private static HashMap<Integer, List<String>> line = new HashMap<>();

    // 先进初始化填空
    private static void init(String[][] params) {
        for (int i = 0; i < params.length; i++) {
            for (int j = 0; j < params.length; j++) {
                String value = params[i][j];
                if (!".".equals(value)) {
                    List<String> list = line.get(i);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(value);
                    line.put(i, list);
                    List<String> list2 = column.get(j);
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                    }
                    list2.add(value);
                    column.put(j, list2);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[][] params = getArgs();
        init(params);
        playSudoku(params, 0, 0 ,1);
    }

    private static boolean playSudoku(String[][] params, int lineNum, int colNum, int startIndex) {
        List<String> tempColValues = new ArrayList<>(column.get(colNum));
        List<String> currentColValues = new ArrayList<>(column.get(colNum));

        List<String> tempLineValues = new ArrayList<>(line.get(lineNum));
        List<String> currentLineValues = new ArrayList<>(line.get(lineNum));
        String oldElement = params[lineNum][colNum];
        // 如果为. 就是需要填空
        if (oldElement.equals(".")) {
            int originalIndex = 1;
            for (int i = startIndex; i < 10; i++) {
                String element = String.valueOf(i);
                if (tempLineValues.contains(element) || tempColValues.contains(element)) {
                    continue;
                }
                // 成功填写一个数字
                tempLineValues.add(element);
                tempColValues.add(element);

                // 换行的情况
                if (colNum == 8) {
                    // 说明这种情况作废
                    if (tempLineValues.size() != 9) {
                        originalIndex++;
                        i = originalIndex;
                        tempColValues = new ArrayList<>(column.get(colNum));
                        tempLineValues = new ArrayList<>(line.get(lineNum));
                        continue;
                    }
                    colNum = 0;
                    ++lineNum;
                } else {
                    ++colNum;
                }
            }
        } else {
            if (colNum == 8) {
                colNum = 0;
                ++lineNum;
            } else {
                ++colNum;
            }
        }
        return false;
        //return playSudoku(params, lineNum, colNum);
    }

    private static String[][] getArgs() {
        String[][] chars = {{
                "5",
                "3",
                ".",
                ".",
                "7",
                ".",
                ".",
                ".",
                "."
        },
                {
                        "6",
                        ".",
                        ".",
                        "1",
                        "9",
                        "5",
                        ".",
                        ".",
                        "."
                },
                {
                        ".",
                        "9",
                        "8",
                        ".",
                        ".",
                        ".",
                        ".",
                        "6",
                        "."
                },
                {
                        "8",
                        ".",
                        ".",
                        ".",
                        "6",
                        ".",
                        ".",
                        ".",
                        "3"
                },
                {
                        "4",
                        ".",
                        ".",
                        "8",
                        ".",
                        "3",
                        ".",
                        ".",
                        "1"
                },
                {
                        "7",
                        ".",
                        ".",
                        ".",
                        "2",
                        ".",
                        ".",
                        ".",
                        "6"
                },
                {
                        ".",
                        "6",
                        ".",
                        ".",
                        ".",
                        ".",
                        "2",
                        "8",
                        "."
                },
                {
                        ".",
                        ".",
                        ".",
                        "4",
                        "1",
                        "9",
                        ".",
                        ".",
                        "5"
                },
                {
                        ".",
                        ".",
                        ".",
                        ".",
                        "8",
                        ".",
                        ".",
                        "7",
                        "9"
                }};
        return chars;
    }
}

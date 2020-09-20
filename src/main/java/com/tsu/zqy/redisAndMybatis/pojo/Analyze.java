package com.tsu.zqy.redisAndMybatis.pojo;

import lombok.Data;

/**
 * @ClassName Analyze
 * @Author Elv1s
 * @Date 2020/2/7 15:00
 * @Description:
 */
@Data
public class Analyze {


    private String openTime;
    private Double income;
    private String cost;
    private Integer peopleSize;
    private Integer count;
    private String totalMoney;
    private String projectName;


    private String industryName;
    private String categoryName;
    private String streetName;

}

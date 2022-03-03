package com.rapis.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author siboran
 * @create 2022/3/3
 */
@Data
public class Commodity {
    private int id;
    private String chineseName;
    private String shortName;
    private String imageUrl;
    private String quantity;
    private BigDecimal price;
    private String category;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}

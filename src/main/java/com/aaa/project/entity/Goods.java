package com.aaa.project.entity;

/**
 * @Author:江Sir
 * @Date:22 2022/08/22 23:02
 * @description: Exercise
 * @Version 1.0.0
 */
public class Goods {
    private Integer goodId;
    private String goodName;
    private Double goodPrice;
    private String goodSlogan;

    @Override
    public String toString() {
        return "Goods{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", goodPrice=" + goodPrice +
                ", goodSlogan='" + goodSlogan + '\'' +
                '}';
    }

    public Goods() {
    }

    public Goods(Integer goodId, String goodName, Double goodPrice, String goodSlogan) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.goodSlogan = goodSlogan;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodSlogan() {
        return goodSlogan;
    }

    public void setGoodSlogan(String goodSlogan) {
        this.goodSlogan = goodSlogan;
    }
}

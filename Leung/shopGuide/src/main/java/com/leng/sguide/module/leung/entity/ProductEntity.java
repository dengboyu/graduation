package com.leng.sguide.module.leung.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
* product表对应实体类
*
* @author by@Deng
* @create 2018-01-31 06:01:00
*/
public class ProductEntity {

    private Integer id;    
    private Integer userId;    //关联用户id
    private String productName;    //产品名称
    private String productIntro;    //产品简介
    private String tag;    //产品标签
    private BigDecimal centPrice;    //产品单价
    private String isShip;    //包邮(0-不包邮,1-包邮)
    private Integer scanAmount;    //浏览量
    private Integer saleAmount;    //销售量
    private String img;    //图片链接
    private BigDecimal originPrice;    //原价格
    private BigDecimal activityPrice;    //活动价格
    private BigDecimal advPrice;    //广告价
    private Integer productAmount;    //产品数量(0-不限数量)
    private Double score;    //客户分数
    private Timestamp createTime;    
    private Timestamp updateTime;    


    /**  
     * 设置:id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** 
     * 获取:id
     */
    public Integer getId() {
        return this.id;
    }

    /**  
     * 设置:userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 
     * 获取:userId
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**  
     * 设置:productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /** 
     * 获取:productName
     */
    public String getProductName() {
        return this.productName;
    }

    /**  
     * 设置:productIntro
     */
    public void setProductIntro(String productIntro) {
        this.productIntro = productIntro;
    }

    /** 
     * 获取:productIntro
     */
    public String getProductIntro() {
        return this.productIntro;
    }

    /**  
     * 设置:tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /** 
     * 获取:tag
     */
    public String getTag() {
        return this.tag;
    }

    /**  
     * 设置:centPrice
     */
    public void setCentPrice(BigDecimal centPrice) {
        this.centPrice = centPrice;
    }

    /** 
     * 获取:centPrice
     */
    public BigDecimal getCentPrice() {
        return this.centPrice;
    }

    /**  
     * 设置:isShip
     */
    public void setIsShip(String isShip) {
        this.isShip = isShip;
    }

    /** 
     * 获取:isShip
     */
    public String getIsShip() {
        return this.isShip;
    }

    /**  
     * 设置:scanAmount
     */
    public void setScanAmount(Integer scanAmount) {
        this.scanAmount = scanAmount;
    }

    /** 
     * 获取:scanAmount
     */
    public Integer getScanAmount() {
        return this.scanAmount;
    }

    /**  
     * 设置:saleAmount
     */
    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    /** 
     * 获取:saleAmount
     */
    public Integer getSaleAmount() {
        return this.saleAmount;
    }

    /**  
     * 设置:img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /** 
     * 获取:img
     */
    public String getImg() {
        return this.img;
    }

    /**  
     * 设置:originPrice
     */
    public void setOriginPrice(BigDecimal originPrice) {
        this.originPrice = originPrice;
    }

    /** 
     * 获取:originPrice
     */
    public BigDecimal getOriginPrice() {
        return this.originPrice;
    }

    /**  
     * 设置:activityPrice
     */
    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }

    /** 
     * 获取:activityPrice
     */
    public BigDecimal getActivityPrice() {
        return this.activityPrice;
    }

    /**  
     * 设置:advPrice
     */
    public void setAdvPrice(BigDecimal advPrice) {
        this.advPrice = advPrice;
    }

    /** 
     * 获取:advPrice
     */
    public BigDecimal getAdvPrice() {
        return this.advPrice;
    }

    /**  
     * 设置:productAmount
     */
    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    /** 
     * 获取:productAmount
     */
    public Integer getProductAmount() {
        return this.productAmount;
    }

    /**  
     * 设置:score
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /** 
     * 获取:score
     */
    public Double getScore() {
        return this.score;
    }

    /**  
     * 设置:createTime
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取:createTime
     */
    public Timestamp getCreateTime() {
        return this.createTime;
    }

    /**  
     * 设置:updateTime
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * 获取:updateTime
     */
    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", productName='" + productName + '\'' +
                ", productIntro='" + productIntro + '\'' +
                ", tag='" + tag + '\'' +
                ", centPrice=" + centPrice +
                ", isShip='" + isShip + '\'' +
                ", scanAmount=" + scanAmount +
                ", saleAmount=" + saleAmount +
                ", img='" + img + '\'' +
                ", originPrice=" + originPrice +
                ", activityPrice=" + activityPrice +
                ", advPrice=" + advPrice +
                ", productAmount=" + productAmount +
                ", score=" + score +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
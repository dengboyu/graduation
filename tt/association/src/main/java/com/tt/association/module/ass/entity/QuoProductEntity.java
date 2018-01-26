package com.tt.association.module.ass.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
* quoProduct表对应实体类
*
* @author by@Deng
* @create 2018-01-26 03:08:22
*/
public class QuoProductEntity {

    private Integer id;    
    private Integer quotationId;    //关联外键
    private String proName;    
    private String norm;    //规格
    private Integer num;    //数量
    private String cent;    //单位
    private BigDecimal centPrice;    //单价
    private BigDecimal totalPrice;    //总价格
    private String remark;    
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
     * 设置:quotationId
     */
    public void setQuotationId(Integer quotationId) {
        this.quotationId = quotationId;
    }

    /** 
     * 获取:quotationId
     */
    public Integer getQuotationId() {
        return this.quotationId;
    }

    /**  
     * 设置:proName
     */
    public void setProName(String proName) {
        this.proName = proName;
    }

    /** 
     * 获取:proName
     */
    public String getProName() {
        return this.proName;
    }

    /**  
     * 设置:norm
     */
    public void setNorm(String norm) {
        this.norm = norm;
    }

    /** 
     * 获取:norm
     */
    public String getNorm() {
        return this.norm;
    }

    /**  
     * 设置:num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /** 
     * 获取:num
     */
    public Integer getNum() {
        return this.num;
    }

    /**  
     * 设置:cent
     */
    public void setCent(String cent) {
        this.cent = cent;
    }

    /** 
     * 获取:cent
     */
    public String getCent() {
        return this.cent;
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
     * 设置:totalPrice
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /** 
     * 获取:totalPrice
     */
    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    /**  
     * 设置:remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 
     * 获取:remark
     */
    public String getRemark() {
        return this.remark;
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
        return "QuoProductEntity{" +
                "id=" + id +
                ", quotationId=" + quotationId +
                ", proName='" + proName + '\'' +
                ", norm='" + norm + '\'' +
                ", num=" + num +
                ", cent='" + cent + '\'' +
                ", centPrice=" + centPrice +
                ", totalPrice=" + totalPrice +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
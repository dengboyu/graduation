package com.tt.association.module.ass.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
* product表对应实体类
*
* @author by@Deng
* @create 2018-01-24 10:49:22
*/
public class ProductEntity {

    private Integer id;    
    private String proName;    
    private Integer sortId;    //关联分类表id
    private String norm;    //规格
    private String proNum;    //产品编号
    private String cent;    //单位
    private BigDecimal costPrice;    //成本价
    private BigDecimal centPrice;    //单价
    private String remark;    //备注
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
     * 设置:sortId
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    /** 
     * 获取:sortId
     */
    public Integer getSortId() {
        return this.sortId;
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
     * 设置:proNum
     */
    public void setProNum(String proNum) {
        this.proNum = proNum;
    }

    /** 
     * 获取:proNum
     */
    public String getProNum() {
        return this.proNum;
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
     * 设置:costPrice
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /** 
     * 获取:costPrice
     */
    public BigDecimal getCostPrice() {
        return this.costPrice;
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
        return "ProductEntity{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", sortId=" + sortId +
                ", norm='" + norm + '\'' +
                ", proNum='" + proNum + '\'' +
                ", cent='" + cent + '\'' +
                ", costPrice=" + costPrice +
                ", centPrice=" + centPrice +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
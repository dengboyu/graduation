package com.tt.association.module.ass.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
* quotation表对应实体类
*
* @author by@Deng
* @create 2018-01-26 03:07:37
*/
public class QuotationEntity {

    private Integer id;    
    private String quoNum;    //报价单编号
    private String companyId;    
    private String linkName;    
    private String phone;    
    private String fax;    
    private String email;    
    private String address;    
    private String quoName;    //报价人
    private java.sql.Date quoTime;    //报价日期
    private BigDecimal totalPrice;    
    private String cent;    //币种
    private BigDecimal transport;    //运费
    private String remark;    //备注
    private String quoPhone;    //报价单顶部电话
    private String quoFax;    //报价单顶部传真
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
     * 设置:quoNum
     */
    public void setQuoNum(String quoNum) {
        this.quoNum = quoNum;
    }

    /** 
     * 获取:quoNum
     */
    public String getQuoNum() {
        return this.quoNum;
    }

    /**  
     * 设置:companyId
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /** 
     * 获取:companyId
     */
    public String getCompanyId() {
        return this.companyId;
    }

    /**  
     * 设置:linkName
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    /** 
     * 获取:linkName
     */
    public String getLinkName() {
        return this.linkName;
    }

    /**  
     * 设置:phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** 
     * 获取:phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**  
     * 设置:fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /** 
     * 获取:fax
     */
    public String getFax() {
        return this.fax;
    }

    /**  
     * 设置:email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * 获取:email
     */
    public String getEmail() {
        return this.email;
    }

    /**  
     * 设置:address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /** 
     * 获取:address
     */
    public String getAddress() {
        return this.address;
    }

    /**  
     * 设置:quoName
     */
    public void setQuoName(String quoName) {
        this.quoName = quoName;
    }

    /** 
     * 获取:quoName
     */
    public String getQuoName() {
        return this.quoName;
    }

    /**  
     * 设置:quoTime
     */
    public void setQuoTime(java.sql.Date quoTime) {
        this.quoTime = quoTime;
    }

    /** 
     * 获取:quoTime
     */
    public java.sql.Date getQuoTime() {
        return this.quoTime;
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
     * 设置:transport
     */
    public void setTransport(BigDecimal transport) {
        this.transport = transport;
    }

    /** 
     * 获取:transport
     */
    public BigDecimal getTransport() {
        return this.transport;
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
     * 设置:quoPhone
     */
    public void setQuoPhone(String quoPhone) {
        this.quoPhone = quoPhone;
    }

    /** 
     * 获取:quoPhone
     */
    public String getQuoPhone() {
        return this.quoPhone;
    }

    /**  
     * 设置:quoFax
     */
    public void setQuoFax(String quoFax) {
        this.quoFax = quoFax;
    }

    /** 
     * 获取:quoFax
     */
    public String getQuoFax() {
        return this.quoFax;
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
        return "QuotationEntity{" +
                "id=" + id +
                ", quoNum='" + quoNum + '\'' +
                ", companyId='" + companyId + '\'' +
                ", linkName='" + linkName + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", quoName='" + quoName + '\'' +
                ", quoTime=" + quoTime +
                ", totalPrice=" + totalPrice +
                ", cent='" + cent + '\'' +
                ", transport=" + transport +
                ", remark='" + remark + '\'' +
                ", quoPhone='" + quoPhone + '\'' +
                ", quoFax='" + quoFax + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
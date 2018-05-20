package com.leng.sguide.module.leung.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
* user_info表对应实体类
*
* @author byDeng
* @create 2018-05-20 08:21:01
*/
public class UserInfoEntity {

    private Integer id;    
    private String nick;    //用户名、昵称
    private String password;    //密码
    private String phone;    //手机号
    private String defaultAttr;    //用户属性
    private String email;    //邮箱
    private String type;    //用户类型(0-普通客户，1-商户)
    private BigDecimal companyPrice;    //公司营业额
    private String companyName;    //公司名称
    private String companyAddress;    //公司地址
    private String linkName;    //公司联系人
    private String telPhone;    //座机号码
    private String harvestPeople;    //收货人
    private String harvestAddress;    //收货地址
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
     * 设置:nick
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /** 
     * 获取:nick
     */
    public String getNick() {
        return this.nick;
    }

    /**  
     * 设置:password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * 获取:password
     */
    public String getPassword() {
        return this.password;
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
     * 设置:defaultAttr
     */
    public void setDefaultAttr(String defaultAttr) {
        this.defaultAttr = defaultAttr;
    }

    /** 
     * 获取:defaultAttr
     */
    public String getDefaultAttr() {
        return this.defaultAttr;
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
     * 设置:type
     */
    public void setType(String type) {
        this.type = type;
    }

    /** 
     * 获取:type
     */
    public String getType() {
        return this.type;
    }

    /**  
     * 设置:companyPrice
     */
    public void setCompanyPrice(BigDecimal companyPrice) {
        this.companyPrice = companyPrice;
    }

    /** 
     * 获取:companyPrice
     */
    public BigDecimal getCompanyPrice() {
        return this.companyPrice;
    }

    /**  
     * 设置:companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /** 
     * 获取:companyName
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**  
     * 设置:companyAddress
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /** 
     * 获取:companyAddress
     */
    public String getCompanyAddress() {
        return this.companyAddress;
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
     * 设置:telPhone
     */
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    /** 
     * 获取:telPhone
     */
    public String getTelPhone() {
        return this.telPhone;
    }

    /**  
     * 设置:harvestPeople
     */
    public void setHarvestPeople(String harvestPeople) {
        this.harvestPeople = harvestPeople;
    }

    /** 
     * 获取:harvestPeople
     */
    public String getHarvestPeople() {
        return this.harvestPeople;
    }

    /**  
     * 设置:harvestAddress
     */
    public void setHarvestAddress(String harvestAddress) {
        this.harvestAddress = harvestAddress;
    }

    /** 
     * 获取:harvestAddress
     */
    public String getHarvestAddress() {
        return this.harvestAddress;
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
        return "UserInfoEntity{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", defaultAttr='" + defaultAttr + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", companyPrice=" + companyPrice +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", linkName='" + linkName + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", harvestPeople='" + harvestPeople + '\'' +
                ", harvestAddress='" + harvestAddress + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
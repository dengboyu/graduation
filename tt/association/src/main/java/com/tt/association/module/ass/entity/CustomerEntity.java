package com.tt.association.module.ass.entity;

import java.sql.Timestamp;


/**
* customer表对应实体类
*
* @author by@Deng
* @create 2018-01-24 10:49:15
*/
public class CustomerEntity {

    private Integer id;    
    private Integer companyId;    //公司外键
    private String linkName;    //联系人姓名
    private String post;    //职务
    private String sex;    
    private String phone;    //手机号
    private String tel;    //电话
    private String wwTel;    //旺旺号码
    private String fax;    //传真
    private String qq;    
    private String msn;    
    private String email;    
    private String address;    
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
     * 设置:companyId
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /** 
     * 获取:companyId
     */
    public Integer getCompanyId() {
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
     * 设置:post
     */
    public void setPost(String post) {
        this.post = post;
    }

    /** 
     * 获取:post
     */
    public String getPost() {
        return this.post;
    }

    /**  
     * 设置:sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /** 
     * 获取:sex
     */
    public String getSex() {
        return this.sex;
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
     * 设置:tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /** 
     * 获取:tel
     */
    public String getTel() {
        return this.tel;
    }

    /**  
     * 设置:wwTel
     */
    public void setWwTel(String wwTel) {
        this.wwTel = wwTel;
    }

    /** 
     * 获取:wwTel
     */
    public String getWwTel() {
        return this.wwTel;
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
     * 设置:qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /** 
     * 获取:qq
     */
    public String getQq() {
        return this.qq;
    }

    /**  
     * 设置:msn
     */
    public void setMsn(String msn) {
        this.msn = msn;
    }

    /** 
     * 获取:msn
     */
    public String getMsn() {
        return this.msn;
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
        return "CustomerEntity{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", linkName='" + linkName + '\'' +
                ", post='" + post + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", wwTel='" + wwTel + '\'' +
                ", fax='" + fax + '\'' +
                ", qq='" + qq + '\'' +
                ", msn='" + msn + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
package com.tt.association.module.ass.entity;

import java.sql.Timestamp;


/**
* company表对应实体类
*
* @author by@Deng
* @create 2018-01-24 10:49:09
*/
public class CompanyEntity {

    private Integer id;    
    private String comName;    
    private String linkPhone;    
    private String linkName;    
    private String fax;    
    private String email;    
    private String address;    
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
     * 设置:comName
     */
    public void setComName(String comName) {
        this.comName = comName;
    }

    /** 
     * 获取:comName
     */
    public String getComName() {
        return this.comName;
    }

    /**  
     * 设置:linkPhone
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    /** 
     * 获取:linkPhone
     */
    public String getLinkPhone() {
        return this.linkPhone;
    }

    /**  
     * 设置:linkName
     */
    public void setlinkName(String linkName) {
        this.linkName = linkName;
    }

    /** 
     * 获取:linkName
     */
    public String getlinkName() {
        return this.linkName;
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
        return "CompanyEntity{" +
                "id=" + id +
                ", comName='" + comName + '\'' +
                ", linkPhone='" + linkPhone + '\'' +
                ", linkName='" + linkName + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
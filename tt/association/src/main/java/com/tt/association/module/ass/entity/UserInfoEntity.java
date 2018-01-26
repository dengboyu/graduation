package com.tt.association.module.ass.entity;

import java.sql.Timestamp;


/**
* user_info表对应实体类
*
* @author by@Deng
* @create 2018-01-24 10:49:47
*/
public class UserInfoEntity {

    private Integer id;    
    private String username;    
    private String password;    
    private String realName;    
    private String email;    
    private String phone;    
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
     * 设置:username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /** 
     * 获取:username
     */
    public String getUsername() {
        return this.username;
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
     * 设置:realName
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /** 
     * 获取:realName
     */
    public String getRealName() {
        return this.realName;
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
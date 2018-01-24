package com.gz.evalution.module.eva.entity;

import java.sql.Timestamp;


/**
* user_info表对应实体类
*
* @author by@Deng
* @create 2018-01-19 11:16:52
*/
public class UserInfoEntity {

    private Integer id;    
    private String username;    //用户名
    private String password;    //密码
    private String email;    //邮箱
    private String identity;    //身份(0-学生，1-教师，2-管理员)
    private String number;    //学号、教师工号
    private String college;    //外键关联学院id
    private String profession;    //关联专业id
    private String phone;    //手机号
    private String statu;    //状态(0-无效，1-有效)
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
     * 设置:identity
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /** 
     * 获取:identity
     */
    public String getIdentity() {
        return this.identity;
    }

    /**  
     * 设置:number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /** 
     * 获取:number
     */
    public String getNumber() {
        return this.number;
    }

    /**  
     * 设置:college
     */
    public void setCollege(String college) {
        this.college = college;
    }

    /** 
     * 获取:college
     */
    public String getCollege() {
        return this.college;
    }

    /**  
     * 设置:profession
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /** 
     * 获取:profession
     */
    public String getProfession() {
        return this.profession;
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
     * 设置:statu
     */
    public void setStatu(String statu) {
        this.statu = statu;
    }

    /** 
     * 获取:statu
     */
    public String getStatu() {
        return this.statu;
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
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", number='" + number + '\'' +
                ", college='" + college + '\'' +
                ", profession='" + profession + '\'' +
                ", phone='" + phone + '\'' +
                ", statu='" + statu + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
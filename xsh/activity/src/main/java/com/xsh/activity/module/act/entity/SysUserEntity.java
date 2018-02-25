package com.xsh.activity.module.act.entity;

import java.util.Date;


/**
* sys_user表对应实体类
*
* @author by@Deng
* @create 2018-02-25 09:29:52
*/
public class SysUserEntity {

    private Integer id;    //主键
    private String number;    //学号
    private String password;    //密码
    private String email;    //邮箱
    private String name;    //姓名
    private String phone;    //手机号
    private String sex;    //性别
    private Integer collegeId;    //学院
    private Integer professionId;    //专业
    private Date createTime;    
    private Date updateTime;    


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
     * 设置:name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * 获取:name
     */
    public String getName() {
        return this.name;
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
     * 设置:collegeId
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    /** 
     * 获取:collegeId
     */
    public Integer getCollegeId() {
        return this.collegeId;
    }

    /**  
     * 设置:professionId
     */
    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }

    /** 
     * 获取:professionId
     */
    public Integer getProfessionId() {
        return this.professionId;
    }

    /**  
     * 设置:createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 
     * 获取:createTime
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**  
     * 设置:updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * 获取:updateTime
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    @Override
    public String toString() {
        return "SysUserEntity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", collegeId=" + collegeId +
                ", professionId=" + professionId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
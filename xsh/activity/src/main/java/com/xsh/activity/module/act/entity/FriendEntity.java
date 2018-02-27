package com.xsh.activity.module.act.entity;

import java.util.Date;


/**
* friend表对应实体类
*
* @author by@Deng
* @create 2018-02-26 08:54:36
*/
public class FriendEntity {

    private Integer id;    
    private Integer friendId;    //好友用户id
    private Integer groupId;    //用户分组id
    private Integer userId;    //当前用户id
    private String number;    //非系统学生学号
    private String name;    //非系统学生姓名
    private String phone;    //手机号
    private Integer collegeId;    //学院id
    private Integer professionId;    //专业id
    private String sex;    //性别
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
     * 设置:friendId
     */
    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    /** 
     * 获取:friendId
     */
    public Integer getFriendId() {
        return this.friendId;
    }

    /**  
     * 设置:groupId
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /** 
     * 获取:groupId
     */
    public Integer getGroupId() {
        return this.groupId;
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
        return "FriendEntity{" +
                "id=" + id +
                ", friendId=" + friendId +
                ", groupId=" + groupId +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", collegeId=" + collegeId +
                ", professionId=" + professionId +
                ", sex='" + sex + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
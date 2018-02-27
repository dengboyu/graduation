package com.xsh.activity.module.act.entity;

import java.util.Date;


/**
* friendGroup表对应实体类
*
* @author by@Deng
* @create 2018-02-26 08:42:33
*/
public class FriendGroupEntity {

    private Integer id;    
    private String groupName;    //分组名称
    private Integer userId;    //关联用户id
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
     * 设置:groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /** 
     * 获取:groupName
     */
    public String getGroupName() {
        return this.groupName;
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
        return "FriendGroupEntity{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
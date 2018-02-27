package com.xsh.activity.module.act.entity;

import java.util.Date;


/**
* collect表对应实体类
*
* @author by@Deng
* @create 2018-02-26 02:55:46
*/
public class CollectEntity {

    private Integer id;    //主键
    private Integer actId;    //活动id
    private Integer userId;    //用户id
    private Date createTime;    //插入数据当前时间
    private Date updateTime;    //更新记录时间


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
     * 设置:actId
     */
    public void setActId(Integer actId) {
        this.actId = actId;
    }

    /** 
     * 获取:actId
     */
    public Integer getActId() {
        return this.actId;
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
        return "CollectEntity{" +
                "id=" + id +
                ", actId=" + actId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
package com.xsh.activity.module.act.entity;

import java.util.Date;


/**
* community表对应实体类
*
* @author by@Deng
* @create 2018-02-25 04:00:47
*/
public class CommunityEntity {

    private Integer id;    //主键
    private String communityName;    //社团名称
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
     * 设置:communityName
     */
    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    /** 
     * 获取:communityName
     */
    public String getCommunityName() {
        return this.communityName;
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
        return "CommunityEntity{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
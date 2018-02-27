package com.xsh.activity.module.act.entity;

import java.util.Date;


/**
* recommandAct表对应实体类
*
* @author by@Deng
* @create 2018-02-26 02:56:00
*/
public class RecommandActEntity {

    private Integer id;    //主键
    private String actId;    //活动id
    private Integer userId;    //用户id
    private Integer recommandUser;    //推荐人id
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
    public void setActId(String actId) {
        this.actId = actId;
    }

    /** 
     * 获取:actId
     */
    public String getActId() {
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
     * 设置:recommandUser
     */
    public void setRecommandUser(Integer recommandUser) {
        this.recommandUser = recommandUser;
    }

    /** 
     * 获取:recommandUser
     */
    public Integer getRecommandUser() {
        return this.recommandUser;
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
        return "RecommandActEntity{" +
                "id=" + id +
                ", actId='" + actId + '\'' +
                ", userId=" + userId +
                ", recommandUser=" + recommandUser +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
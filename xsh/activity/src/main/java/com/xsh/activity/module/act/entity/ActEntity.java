package com.xsh.activity.module.act.entity;

import java.util.Date;


/**
* act表对应实体类
*
* @author by@Deng
* @create 2018-02-26 02:55:32
*/
public class ActEntity {

    private Integer id;    
    private String actName;    //活动名称
    private String actPerson;    //活动负责人
    private Integer communityId;    //社团id
    private Date actTime;    //活动时间
    private String actWhere;    //活动地点
    private String actIntro;    //活动简介
    private String actDetail;    //活动详情
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
     * 设置:actName
     */
    public void setActName(String actName) {
        this.actName = actName;
    }

    /** 
     * 获取:actName
     */
    public String getActName() {
        return this.actName;
    }

    /**  
     * 设置:actPerson
     */
    public void setActPerson(String actPerson) {
        this.actPerson = actPerson;
    }

    /** 
     * 获取:actPerson
     */
    public String getActPerson() {
        return this.actPerson;
    }

    /**  
     * 设置:communityId
     */
    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    /** 
     * 获取:communityId
     */
    public Integer getCommunityId() {
        return this.communityId;
    }

    /**  
     * 设置:actTime
     */
    public void setActTime(Date actTime) {
        this.actTime = actTime;
    }

    /** 
     * 获取:actTime
     */
    public Date getActTime() {
        return this.actTime;
    }

    /**  
     * 设置:actWhere
     */
    public void setActWhere(String actWhere) {
        this.actWhere = actWhere;
    }

    /** 
     * 获取:actWhere
     */
    public String getActWhere() {
        return this.actWhere;
    }

    /**  
     * 设置:actIntro
     */
    public void setActIntro(String actIntro) {
        this.actIntro = actIntro;
    }

    /** 
     * 获取:actIntro
     */
    public String getActIntro() {
        return this.actIntro;
    }

    /**  
     * 设置:actDetail
     */
    public void setActDetail(String actDetail) {
        this.actDetail = actDetail;
    }

    /** 
     * 获取:actDetail
     */
    public String getActDetail() {
        return this.actDetail;
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
        return "ActEntity{" +
                "id=" + id +
                ", actName='" + actName + '\'' +
                ", actPerson='" + actPerson + '\'' +
                ", communityId=" + communityId +
                ", actTime=" + actTime +
                ", actWhere='" + actWhere + '\'' +
                ", actIntro='" + actIntro + '\'' +
                ", actDetail='" + actDetail + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
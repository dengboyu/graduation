package com.leng.sguide.module.leung.entity;

import java.sql.Timestamp;


/**
* content表对应实体类
*
* @author by@Deng
* @create 2018-01-31 06:07:50
*/
public class ContentEntity {

    private Integer id;    
    private String content;    //评论内容
    private String score;    //分数
    private Integer productId;    //关联产品id
    private Integer userId;    //关联user表
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
     * 设置:content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /** 
     * 获取:content
     */
    public String getContent() {
        return this.content;
    }

    /**  
     * 设置:score
     */
    public void setScore(String score) {
        this.score = score;
    }

    /** 
     * 获取:score
     */
    public String getScore() {
        return this.score;
    }

    /**  
     * 设置:productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /** 
     * 获取:productId
     */
    public Integer getProductId() {
        return this.productId;
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
        return "ContentEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", score='" + score + '\'' +
                ", productId=" + productId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
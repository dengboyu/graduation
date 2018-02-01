package com.leng.sguide.module.leung.entity;

import java.sql.Timestamp;


/**
* shop表对应实体类
*
* @author by@Deng
* @create 2018-01-29 01:48:00
*/
public class ShopEntity {

    private Integer id;    
    private Integer productId;    //关联产品id
    private Integer userId;    //关联用户id
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
        return "ShopEntity{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
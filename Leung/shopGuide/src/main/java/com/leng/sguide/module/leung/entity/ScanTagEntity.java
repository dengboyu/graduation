package com.leng.sguide.module.leung.entity;

import java.sql.Timestamp;


/**
* scan_tag表对应实体类
*
* @author by@Deng
* @create 2018-02-01 08:58:25
*/
public class ScanTagEntity {

    private Integer id;    
    private Integer userId;    //关联主账户
    private String tag;    //产品标签
    private Integer amount;    //浏览次数
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
     * 设置:tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /** 
     * 获取:tag
     */
    public String getTag() {
        return this.tag;
    }

    /**  
     * 设置:amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /** 
     * 获取:amount
     */
    public Integer getAmount() {
        return this.amount;
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
        return "ScanTagEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", tag='" + tag + '\'' +
                ", amount=" + amount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
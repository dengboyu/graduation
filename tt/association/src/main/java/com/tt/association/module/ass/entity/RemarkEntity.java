package com.tt.association.module.ass.entity;

import java.sql.Timestamp;


/**
* remark表对应实体类
*
* @author by@Deng
* @create 2018-01-24 10:49:41
*/
public class RemarkEntity {

    private Integer id;    
    private String remark;    
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
     * 设置:remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /** 
     * 获取:remark
     */
    public String getRemark() {
        return this.remark;
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
        return "RemarkEntity{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
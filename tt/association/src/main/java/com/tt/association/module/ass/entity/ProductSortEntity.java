package com.tt.association.module.ass.entity;

import java.sql.Timestamp;


/**
* product_sort表对应实体类
*
* @author by@Deng
* @create 2018-01-24 10:49:27
*/
public class ProductSortEntity {

    private Integer id;    
    private String sortName;    
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
     * 设置:sortName
     */
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    /** 
     * 获取:sortName
     */
    public String getSortName() {
        return this.sortName;
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
        return "ProductSortEntity{" +
                "id=" + id +
                ", sortName='" + sortName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
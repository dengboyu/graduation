package com.gz.evalution.module.area.entity;

import java.sql.Timestamp;


/**
* area_city表对应实体类
*
* @author by@Deng
* @create 2018-01-07 11:36:46
*/
public class AreaCityEntity {

    private Integer id;    
    private Integer cityId;    //城市编号
    private String cityName;    //城市名称
    private Integer fatherId;    //对应省份(外键)
    private Timestamp createTime;    //创建时间
    private Timestamp updateTime;    //更新时间
    private String test;    


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
     * 设置:cityId
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /** 
     * 获取:cityId
     */
    public Integer getCityId() {
        return this.cityId;
    }

    /**  
     * 设置:cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /** 
     * 获取:cityName
     */
    public String getCityName() {
        return this.cityName;
    }

    /**  
     * 设置:fatherId
     */
    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    /** 
     * 获取:fatherId
     */
    public Integer getFatherId() {
        return this.fatherId;
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

    /**  
     * 设置:test
     */
    public void setTest(String test) {
        this.test = test;
    }

    /** 
     * 获取:test
     */
    public String getTest() {
        return this.test;
    }

    @Override
    public String toString() {
        return "AreaCityEntity{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", fatherId=" + fatherId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", test='" + test + '\'' +
                '}';
    }

}
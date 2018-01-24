package com.gz.evalution.module.eva.entity;

import java.util.Date;


/**
* profession表对应实体类
*
* @author by@Deng
* @create 2018-01-19 05:00:00
*/
public class ProfessionEntity {

    private Integer id;    
    private String proNum;    //专业编号
    private String proName;    //专业名称
    private java.sql.Date startTime;    //成立时间
    private String collegeId;    //学院外键
    private String statu;    //有效性(0-无效，1-有效)
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
     * 设置:proNum
     */
    public void setProNum(String proNum) {
        this.proNum = proNum;
    }

    /** 
     * 获取:proNum
     */
    public String getProNum() {
        return this.proNum;
    }

    /**  
     * 设置:proName
     */
    public void setProName(String proName) {
        this.proName = proName;
    }

    /** 
     * 获取:proName
     */
    public String getProName() {
        return this.proName;
    }

    /**  
     * 设置:startTime
     */
    public void setStartTime(java.sql.Date startTime) {
        this.startTime = startTime;
    }

    /** 
     * 获取:startTime
     */
    public java.sql.Date getStartTime() {
        return this.startTime;
    }

    /**  
     * 设置:collegeId
     */
    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    /** 
     * 获取:collegeId
     */
    public String getCollegeId() {
        return this.collegeId;
    }

    /**  
     * 设置:statu
     */
    public void setStatu(String statu) {
        this.statu = statu;
    }

    /** 
     * 获取:statu
     */
    public String getStatu() {
        return this.statu;
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
        return "ProfessionEntity{" +
                "id=" + id +
                ", proNum='" + proNum + '\'' +
                ", proName='" + proName + '\'' +
                ", startTime=" + startTime +
                ", collegeId='" + collegeId + '\'' +
                ", statu='" + statu + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
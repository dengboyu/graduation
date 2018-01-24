package com.gz.evalution.module.eva.entity;

import java.util.Date;


/**
* college表对应实体类
*
* @author by@Deng
* @create 2018-01-19 04:59:46
*/
public class CollegeEntity {

    private Integer id;    
    private String collegeNum;    //学院编号
    private String collegeName;    //学院名称
    private java.sql.Date startTime;    //成立时间
    private String statu;    //状态(0-无效，1-有效)
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
     * 设置:collegeNum
     */
    public void setCollegeNum(String collegeNum) {
        this.collegeNum = collegeNum;
    }

    /** 
     * 获取:collegeNum
     */
    public String getCollegeNum() {
        return this.collegeNum;
    }

    /**  
     * 设置:collegeName
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /** 
     * 获取:collegeName
     */
    public String getCollegeName() {
        return this.collegeName;
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
        return "CollegeEntity{" +
                "id=" + id +
                ", collegeNum='" + collegeNum + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", startTime=" + startTime +
                ", statu='" + statu + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
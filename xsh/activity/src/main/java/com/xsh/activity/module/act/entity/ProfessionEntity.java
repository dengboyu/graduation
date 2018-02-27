package com.xsh.activity.module.act.entity;

import java.util.Date;


/**
* profession表对应实体类
*
* @author by@Deng
* @create 2018-02-25 02:08:52
*/
public class ProfessionEntity {

    private Integer id;    //主键
    private Integer collegeId;    //学院id
    private String professionName;    //专业名称
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
     * 设置:collegeId
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    /** 
     * 获取:collegeId
     */
    public Integer getCollegeId() {
        return this.collegeId;
    }

    /**  
     * 设置:professionName
     */
    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    /** 
     * 获取:professionName
     */
    public String getProfessionName() {
        return this.professionName;
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
                ", collegeId=" + collegeId +
                ", professionName='" + professionName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
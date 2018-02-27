package com.xsh.activity.module.act.entity;

import java.util.Date;


/**
* college表对应实体类
*
* @author by@Deng
* @create 2018-02-25 02:08:39
*/
public class CollegeEntity {

    private Integer id;    //主键
    private String collegeName;    //学院名称
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
                ", collegeName='" + collegeName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
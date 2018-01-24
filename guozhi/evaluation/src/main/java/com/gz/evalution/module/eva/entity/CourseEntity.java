package com.gz.evalution.module.eva.entity;

import java.util.Date;


/**
* course表对应实体类
*
* @author by@Deng
* @create 2018-01-24 04:23:33
*/
public class CourseEntity {

    private Integer id;    
    private String courseNum;    //课程编号
    private String courseName;    //课程名称
    private String college;    //外键关联学院id
    private String profession;    //关联专业id
    private String teacher;    //关联user_info表的id
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
     * 设置:courseNum
     */
    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    /** 
     * 获取:courseNum
     */
    public String getCourseNum() {
        return this.courseNum;
    }

    /**  
     * 设置:courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /** 
     * 获取:courseName
     */
    public String getCourseName() {
        return this.courseName;
    }

    /**  
     * 设置:college
     */
    public void setCollege(String college) {
        this.college = college;
    }

    /** 
     * 获取:college
     */
    public String getCollege() {
        return this.college;
    }

    /**  
     * 设置:profession
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /** 
     * 获取:profession
     */
    public String getProfession() {
        return this.profession;
    }

    /**  
     * 设置:teacher
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /** 
     * 获取:teacher
     */
    public String getTeacher() {
        return this.teacher;
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
        return "CourseEntity{" +
                "id=" + id +
                ", courseNum='" + courseNum + '\'' +
                ", courseName='" + courseName + '\'' +
                ", college='" + college + '\'' +
                ", profession='" + profession + '\'' +
                ", teacher='" + teacher + '\'' +
                ", statu='" + statu + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
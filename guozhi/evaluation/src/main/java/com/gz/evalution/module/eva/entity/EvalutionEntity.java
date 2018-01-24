package com.gz.evalution.module.eva.entity;

import java.util.Date;


/**
* evalution表对应实体类
*
* @author by@Deng
* @create 2018-01-19 11:26:57
*/
public class EvalutionEntity {

    private Integer id;    
    private String answer;    //答题分数
    private Integer totalCore;    //总分
    private String studentId;    //关联学生外键
    private String teacherId;    //关联教师外键
    private String couseId;    //课程id
    private String statu;    
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
     * 设置:answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /** 
     * 获取:answer
     */
    public String getAnswer() {
        return this.answer;
    }

    /**  
     * 设置:totalCore
     */
    public void setTotalCore(Integer totalCore) {
        this.totalCore = totalCore;
    }

    /** 
     * 获取:totalCore
     */
    public Integer getTotalCore() {
        return this.totalCore;
    }

    /**  
     * 设置:studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /** 
     * 获取:studentId
     */
    public String getStudentId() {
        return this.studentId;
    }

    /**  
     * 设置:teacherId
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    /** 
     * 获取:teacherId
     */
    public String getTeacherId() {
        return this.teacherId;
    }

    /**  
     * 设置:couseId
     */
    public void setCouseId(String couseId) {
        this.couseId = couseId;
    }

    /** 
     * 获取:couseId
     */
    public String getCouseId() {
        return this.couseId;
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
        return "EvalutionEntity{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", totalCore=" + totalCore +
                ", studentId='" + studentId + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", couseId='" + couseId + '\'' +
                ", statu='" + statu + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
package com.gz.evalution.module.eva.entity;

import java.util.Date;


/**
* question表对应实体类
*
* @author by@Deng
* @create 2018-01-19 11:27:06
*/
public class QuestionEntity {

    private Integer id;    
    private String tag;    //标签
    private String question;    //问题
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
     * 设置:question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /** 
     * 获取:question
     */
    public String getQuestion() {
        return this.question;
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
        return "QuestionEntity{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", question='" + question + '\'' +
                ", statu='" + statu + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
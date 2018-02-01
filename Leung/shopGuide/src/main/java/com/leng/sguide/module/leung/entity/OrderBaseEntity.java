package com.leng.sguide.module.leung.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
* order_base表对应实体类
*
* @author by@Deng
* @create 2018-01-31 08:52:30
*/
public class OrderBaseEntity {

    private Integer id;    
    private String orderId;    //订单号
    private Integer userId;    //关联userId表信息主键
    private Integer productId;    //关联商品的id
    private Integer account;    //购买的数量
    private BigDecimal totalMoney;    //购买金额
    private String address;    //联系地址
    private String linkName;    //联系人
    private String phone;    //购买手机号
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
     * 设置:orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /** 
     * 获取:orderId
     */
    public String getOrderId() {
        return this.orderId;
    }

    /**  
     * 设置:userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /** 
     * 获取:userId
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**  
     * 设置:productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /** 
     * 获取:productId
     */
    public Integer getProductId() {
        return this.productId;
    }

    /**  
     * 设置:account
     */
    public void setAccount(Integer account) {
        this.account = account;
    }

    /** 
     * 获取:account
     */
    public Integer getAccount() {
        return this.account;
    }

    /**  
     * 设置:totalMoney
     */
    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    /** 
     * 获取:totalMoney
     */
    public BigDecimal getTotalMoney() {
        return this.totalMoney;
    }

    /**  
     * 设置:address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /** 
     * 获取:address
     */
    public String getAddress() {
        return this.address;
    }

    /**  
     * 设置:linkName
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    /** 
     * 获取:linkName
     */
    public String getLinkName() {
        return this.linkName;
    }

    /**  
     * 设置:phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** 
     * 获取:phone
     */
    public String getPhone() {
        return this.phone;
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
        return "OrderBaseEntity{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", productId=" + productId +
                ", account=" + account +
                ", totalMoney=" + totalMoney +
                ", address='" + address + '\'' +
                ", linkName='" + linkName + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
package com.tt.association.module.ass.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author by@Deng
 * @create 2018-01-26 13:54
 */
public class QuotationVo {

    private String comName; //公司名字
    private QuotationEntity quotationEntity;
    private List<QuoProductEntity> quoProductEntityList;


    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public QuotationEntity getQuotationEntity() {
        return quotationEntity;
    }

    public void setQuotationEntity(QuotationEntity quotationEntity) {
        this.quotationEntity = quotationEntity;
    }

    public List<QuoProductEntity> getQuoProductEntityList() {
        return quoProductEntityList;
    }

    public void setQuoProductEntityList(List<QuoProductEntity> quoProductEntityList) {
        this.quoProductEntityList = quoProductEntityList;
    }


    @Override
    public String toString() {
        return "QuotationVo{" +
                "comName='" + comName + '\'' +
                ", quotationEntity=" + quotationEntity +
                ", quoProductEntityList=" + quoProductEntityList +
                '}';
    }
}

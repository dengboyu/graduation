package com.tt.association.module.ass.service;

import com.tt.association.module.ass.entity.QuotationEntity;
import com.tt.association.common.structure.service.BaseService;
import com.tt.association.module.ass.entity.QuotationVo;

import javax.transaction.Transactional;


/**
* quotation表对应实体类的业务层接口
*
* @author by@Deng
* @create 2018-01-24 10:49:37
*/
public interface QuotationService extends BaseService<QuotationEntity> {


    /**
     * 添加报价单
     * @author by@Deng
     * @date 2018/1/26 下午2:00
     */
    Integer insertQuotationEntity(QuotationVo quotationVo) throws Exception;


    /**
     * 获取订单号
     * @author by@Deng
     * @date 2018/1/26 下午2:01
     */
    String getProNum() throws Exception;


}
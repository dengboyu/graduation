package com.tt.association.module.ass.serviceImpl;

import com.tt.association.module.ass.entity.QuoProductEntity;
import com.tt.association.module.ass.entity.QuotationVo;
import com.tt.association.module.ass.service.QuoProductService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import com.tt.association.module.ass.entity.QuotationEntity;
import com.tt.association.module.ass.service.QuotationService;
import com.tt.association.module.ass.dao.QuotationDao;
import com.tt.association.common.structure.serviceAbstract.BaseServiceAbstract;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
* quotation表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-24 10:49:37
*/
@Service
@Transactional
public class QuotationServiceImpl extends BaseServiceAbstract<QuotationDao,QuotationEntity> implements QuotationService {

    @Resource
    private QuoProductService quoProductService;



    /**
     * 添加报价单
     * @author by@Deng
     * @date 2018/1/26 下午2:00
     */

    @Override
    public Integer insertQuotationEntity(QuotationVo quotationVo) throws Exception {

        String quoNum = getProNum();    //获取订单号
        QuotationEntity quotationEntity = quotationVo.getQuotationEntity();
        quotationEntity.setQuoNum(quoNum);

        //插入报价单基本信息
        insertEntity(quotationEntity);

        List<QuoProductEntity> quoProductEntityList = quotationVo.getQuoProductEntityList();
        for(QuoProductEntity quoProductEntity:quoProductEntityList){
            quoProductEntity.setQuotationId(quotationEntity.getId());
        }

        quoProductService.insertEntityByBatch(quoProductEntityList);
        return 1;
    }


    /**
     * 获取订单号
     * @author by@Deng
     * @date 2018/1/26 下午2:02
     */
    @Override
    public String getProNum() throws Exception {

        String today = DateFormatUtils.format(new Date(),"yyyyMMdd");
        Integer random = (int)((Math.random()*9+1)*10000);
        return today+random;
    }


}
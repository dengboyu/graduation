package com.tt.association.module.ass.controller;

import com.tt.association.common.annotation.Result;
import com.tt.association.module.ass.entity.QuoProductEntity;
import com.tt.association.module.ass.entity.QuotationEntity;
import com.tt.association.module.ass.entity.QuotationVo;
import com.tt.association.module.ass.service.CompanyService;
import com.tt.association.module.ass.service.QuoProductService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.tt.association.module.ass.service.QuotationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* quotation表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-24 10:49:37
*/
@RestController
@RequestMapping("quotation")
@Result
public class QuotationController{

    @Resource
    private QuotationService quotationService;
    @Resource
    private CompanyService companyService;
    @Resource
    private QuoProductService quoProductService;


    /**
     * 添加报价单
     * @author by@Deng
     * @date 2018/1/26 下午1:56
     */
    @PostMapping("insertQuotationEntity")
    public Object insertQuotationEntity(@RequestBody QuotationVo quotationVo) throws Exception{
        return quotationService.insertQuotationEntity(quotationVo);
    }


    /**
     * 获取报价菜单列表
     * @author by@Deng
     * @date 2018/1/26 下午4:18
     */
    @GetMapping("getQuotationList")
    public Object getQuotationList() throws Exception{
        List<Map<String,Object>> retList = new ArrayList<>();

        List<QuotationEntity> quotationEntityList = quotationService.findEntityList(null);
        for(QuotationEntity quotationEntity:quotationEntityList){
            Map<String,Object> map = new HashMap<>();

            map.put("id",quotationEntity.getId());
            map.put("quoNum",quotationEntity.getQuoNum());
            map.put("linkName",quotationEntity.getLinkName());
            map.put("quoName",quotationEntity.getQuoName());
            map.put("quoTime",quotationEntity.getQuoTime());
            map.put("totalPrice",quotationEntity.getTotalPrice());
            map.put("cent",quotationEntity.getCent());
            map.put("comName",companyService.findEntityByMainId(quotationEntity.getCompanyId()).getComName());
            map.put("createTime", DateFormatUtils.format(quotationEntity.getCreateTime(),"yyyy-MM-dd"));

            retList.add(map);
        }

        return retList;
    }




    /**
     * 获取报价单详情
     * @author by@Deng
     * @date 2018/1/26 下午4:18
     */
    @GetMapping("getQuotationDetail")
    public Object getQuotationDetail(@RequestParam String id) throws Exception{
        QuotationVo quotationVo = new QuotationVo();

        QuotationEntity quotationEntity = quotationService.findEntityByMainId(id);
        quotationVo.setQuotationEntity(quotationEntity);

        quotationVo.setComName(companyService.findEntityByMainId(quotationEntity.getCompanyId()).getComName());

        QuoProductEntity quoProductEntity = new QuoProductEntity();
        quoProductEntity.setQuotationId(quotationEntity.getId());
        List<QuoProductEntity> quoProductEntityList = quoProductService.findEntityList(quoProductEntity);
        quotationVo.setQuoProductEntityList(quoProductEntityList);

        return quotationVo;
    }





}
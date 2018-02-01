package com.leng.sguide.module.leung.controller;

import com.leng.sguide.common.annotation.Result;
import com.leng.sguide.common.exception.ByException;
import com.leng.sguide.module.leung.entity.ContentEntity;
import com.leng.sguide.module.leung.entity.OrderBaseEntity;
import com.leng.sguide.module.leung.entity.ProductEntity;
import com.leng.sguide.module.leung.entity.UserInfoEntity;
import com.leng.sguide.module.leung.service.*;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* order_base表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-30 01:30:52
*/
@RestController
@RequestMapping("orderBase")
@Result
public class OrderBaseController{

    @Resource
    private OrderBaseService orderBaseService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private ProductService productService;
    @Resource
    private CurrencyService currencyService;
    @Resource
    private ContentService contentService;


    /**
     * 获取订单列表
     * @author by@Deng
     * @date 2018/1/30 上午12:34
     */
    @GetMapping("getOrderList")
    public Object getOrderList(@RequestParam Map<String,Object> map) throws Exception{
        Map<String,Object> retFinalMap = new HashMap<>();

        Object object = SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(object==null)throw  new ByException("请先登录");
        UserInfoEntity userInfoEntity = (UserInfoEntity) object;

        Map<String,Integer> pageMap = currencyService.getPageParam(map);

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("pageStart",pageMap.get("pageStart"));
        paramMap.put("pageSize",pageMap.get("pageSize"));
        paramMap.put("userId",userInfoEntity.getId());
        List<OrderBaseEntity> orderBaseEntityList = orderBaseService.findPageEntityList(paramMap);

        List<Map<String,Object>> mapList = new ArrayList<>();

        for(OrderBaseEntity orderBaseEntity:orderBaseEntityList){
            Map<String,Object> retMap = new HashMap<>();
            retMap.put("id",orderBaseEntity.getId());
            retMap.put("orderId",orderBaseEntity.getOrderId());
            retMap.put("createTime", DateFormatUtils.format(orderBaseEntity.getCreateTime(),"yyyy-MM-dd"));

            ProductEntity productEntity = productService.findEntityByMainId(orderBaseEntity.getProductId());

            retMap.put("productId",productEntity.getId());
            retMap.put("productName",productEntity.getProductName());
            retMap.put("nick",userInfoService.findEntityByMainId(productEntity.getUserId()).getNick());
            retMap.put("centPrice",productEntity.getCentPrice());
            retMap.put("account",orderBaseEntity.getAccount());
            retMap.put("totalMoney",orderBaseEntity.getTotalMoney());

            retMap.put("isContent",0);
            ContentEntity contentEntity = new ContentEntity();
            contentEntity.setUserId(userInfoEntity.getId());
            contentEntity.setProductId(productEntity.getId());

            if(contentService.findEntityByOne(contentEntity)!=null){
                retMap.put("isContent",1);
            }

            mapList.add(retMap);
        }

        retFinalMap.put("mapList",mapList);
        retFinalMap.put("totalAccount",orderBaseService.findPageEntityCount(paramMap));

        return retFinalMap;
    }


    /**
     * 插入新的订单
     * @author by@Deng
     * @date 2018/1/31 下午9:25
     */
    @PostMapping("insertOrderBaseEntity")
    public Object insertOrderBaseEntity(@RequestBody OrderBaseEntity orderBaseEntity) throws Exception{

        Object object = SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(object==null) throw new ByException("请先登录");

        UserInfoEntity userInfoEntity = (UserInfoEntity) object;
        orderBaseEntity.setUserId(userInfoEntity.getId());

        return orderBaseService.addOrderBaseEntity(orderBaseEntity);
    }


}
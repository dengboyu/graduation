package com.leng.sguide.module.leung.serviceImpl;

import com.leng.sguide.module.leung.entity.ProductEntity;
import com.leng.sguide.module.leung.entity.ShopEntity;
import com.leng.sguide.module.leung.entity.UserInfoEntity;
import com.leng.sguide.module.leung.service.ProductService;
import com.leng.sguide.module.leung.service.ShopService;
import com.leng.sguide.module.leung.service.UserInfoService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.leng.sguide.module.leung.entity.OrderBaseEntity;
import com.leng.sguide.module.leung.service.OrderBaseService;
import com.leng.sguide.module.leung.dao.OrderBaseDao;
import com.leng.sguide.common.structure.serviceAbstract.BaseServiceAbstract;

import javax.annotation.Resource;
import java.util.Date;


/**
* order_base表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-30 01:30:52
*/
@Service
@Transactional
public class OrderBaseServiceImpl extends BaseServiceAbstract<OrderBaseDao,OrderBaseEntity> implements OrderBaseService {

    @Resource
    private ProductService productService;
    @Resource
    private ShopService shopService;
    @Resource
    private UserInfoService userInfoService;




    /**
     * 插入订单管理
     * @author by@Deng
     * @date 2018/1/31 下午9:27
     */
    @Override
    public Integer addOrderBaseEntity(OrderBaseEntity orderBaseEntity) throws Exception {

        ProductEntity productEntity = productService.findEntityByMainId(orderBaseEntity.getProductId());
        productEntity.setSaleAmount(orderBaseEntity.getAccount()+productEntity.getSaleAmount());
        productEntity.setProductAmount(productEntity.getProductAmount()-orderBaseEntity.getAccount());

        //更新产品数量
        productService.updateEntity(productEntity);

        //如果在购物车中将其删除
        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setUserId(orderBaseEntity.getUserId());
        shopEntity.setProductId(orderBaseEntity.getProductId());
        shopEntity = shopService.findEntityByOne(shopEntity);
        if(shopEntity!=null){
            shopService.deleteEntity(shopEntity.getId());
        }

        //更新用户金额
        UserInfoEntity userInfoEntity = userInfoService.findEntityByMainId(productEntity.getUserId());
        userInfoEntity.setCompanyPrice(userInfoEntity.getCompanyPrice().add(orderBaseEntity.getTotalMoney()));
        userInfoService.updateEntity(userInfoEntity);

        orderBaseEntity.setOrderId(getOrderId());

        insertEntity(orderBaseEntity);
        return 1;
    }


    /**
     * 获取订单号
     * @author by@Deng
     * @date 2018/1/31 下午9:37
     */
    public String getOrderId(){

        String today = DateFormatUtils.format(new Date(),"yyyyMMdd");
        Integer random = (int)((Math.random()*9+1)*10000);
        return today+random;
    }





}
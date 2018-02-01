package com.leng.sguide.module.leung.service;

import com.leng.sguide.module.leung.entity.OrderBaseEntity;
import com.leng.sguide.common.structure.service.BaseService;


/**
* order_base表对应实体类的业务层接口
*
* @author by@Deng
* @create 2018-01-30 01:30:52
*/
public interface OrderBaseService extends BaseService<OrderBaseEntity> {


    /**
     * 插入订单管理
     * @author by@Deng
     * @date 2018/1/31 下午9:27
     */
    Integer addOrderBaseEntity(OrderBaseEntity orderBaseEntity) throws Exception;

}
package com.leng.sguide.module.leung.controller;

import com.leng.sguide.common.annotation.Result;
import com.leng.sguide.common.exception.ByException;
import com.leng.sguide.module.leung.entity.ShopEntity;
import com.leng.sguide.module.leung.entity.UserInfoEntity;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.leng.sguide.module.leung.service.ShopService;

import java.util.Map;


/**
* shop表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-29 01:48:00
*/
@RestController
@RequestMapping("shop")
@Result
public class ShopController{

    @Resource
    private ShopService shopService;



    /**
     * 获取购车列表
     * @author by@Deng
     * @date 2018/1/30 上午12:34
     */
    @GetMapping("getShopCarList")
    public Object getShopCarList(@RequestParam Map<String,Object> map) throws Exception{
        Object object = SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(object==null)throw  new ByException("请先登录");

        UserInfoEntity userInfoEntity = (UserInfoEntity) object;
        map.put("userId",userInfoEntity.getId());
        map.put("nick",userInfoEntity.getNick());

        return shopService.getShopCarList(map);
    }


    /**
     * 添加购物车
     * @author by@Deng
     * @date 2018/1/31 下午9:51
     */
    @PostMapping("insertShopEntity")
    public Object insertShopEntity(@RequestParam Integer productId) throws Exception{

        Object object = SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(object==null)throw  new ByException("请先登录");

        UserInfoEntity userInfoEntity = (UserInfoEntity) object;

        ShopEntity shopEntity = new ShopEntity();
        shopEntity.setProductId(productId);
        shopEntity.setUserId(userInfoEntity.getId());

        return shopService.insertEntity(shopEntity);
    }


    /**
     * 删除购物车
     * @author by@Deng
     * @date 2018/1/31 下午10:19
     */
    @PostMapping("deleteShopEntity")
    public Object deleteShopEntity(@RequestParam Integer id) throws Exception{
        return shopService.deleteEntity(id);
    }

}
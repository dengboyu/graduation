package com.leng.sguide.module.leung.controller;

import com.leng.sguide.common.annotation.Result;
import com.leng.sguide.common.exception.ByException;
import com.leng.sguide.module.leung.entity.ContentEntity;
import com.leng.sguide.module.leung.entity.ProductEntity;
import com.leng.sguide.module.leung.entity.UserInfoEntity;
import com.leng.sguide.module.leung.service.ProductService;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.leng.sguide.module.leung.service.ContentService;

import java.math.BigDecimal;


/**
* content表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-29 01:47:45
*/
@RestController
@RequestMapping("content")
@Result
public class ContentController{

    @Resource
    private ContentService contentService;
    @Resource
    private ProductService productService;


    /**
     * 添加评论消息
     * @author by@Deng
     * @date 2018/1/31 下午11:44
     */
    @PostMapping("insertContentEntity")
    public Object insertContentEntity(@RequestBody ContentEntity contentEntity) throws Exception{
        Object object = SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        if(object==null) throw new ByException("请先登录");

        UserInfoEntity userInfoEntity = (UserInfoEntity) object;
        contentEntity.setUserId(userInfoEntity.getId());

        contentService.insertEntity(contentEntity);

        //重新计算评分
        ProductEntity productEntity = productService.findEntityByMainId(contentEntity.getProductId());

        Double scoreNow = productEntity.getScore()+(contentService.getContentScore(contentEntity.getProductId().toString())/5);
        productEntity.setScore(scoreNow);

        return productService.updateEntity(productEntity);
    }

}
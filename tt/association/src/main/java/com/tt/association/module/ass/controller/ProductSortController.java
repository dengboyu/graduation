package com.tt.association.module.ass.controller;

import com.tt.association.common.annotation.Result;
import com.tt.association.module.ass.entity.ProductSortEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.tt.association.module.ass.service.ProductSortService;


/**
* product_sort表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-24 10:49:27
*/
@RestController
@RequestMapping("productSort")
@Result
public class ProductSortController{

    @Resource
    private ProductSortService productSortService;


    /**
     * 添加产品分类
     * @author by@Deng
     * @date 2018/1/25 上午8:37
     */
    @PostMapping("insertProductSortEntity")
    public Object insertProductSortEntity(@RequestBody ProductSortEntity productSortEntity) throws Exception{
        return productSortService.insertEntity(productSortEntity);
    }


    /**
     * 获取已有产品分类名称
     * @author by@Deng
     * @date 2018/1/25 上午8:38
     */
    @GetMapping("getProductSortList")
    public Object getProductSortList() throws Exception{
        return productSortService.findEntityList(null);
    }

}
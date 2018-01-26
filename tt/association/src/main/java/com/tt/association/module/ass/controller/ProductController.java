package com.tt.association.module.ass.controller;

import com.tt.association.common.annotation.Result;
import com.tt.association.module.ass.entity.ProductEntity;
import com.tt.association.module.ass.service.ProductSortService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.tt.association.module.ass.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* product表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-24 10:49:22
*/
@RestController
@RequestMapping("product")
@Result
public class ProductController{

    @Resource
    private ProductService productService;
    @Resource
    private ProductSortService productSortService;


    /**
     * 添加产品信息
     * @author by@Deng
     * @date 2018/1/25 下午6:27
     */
    @PostMapping("insertProductEntity")
    public Object insertProductEntity(@RequestBody ProductEntity productEntity) throws Exception{
        return productService.insertEntity(productEntity);
    }


    /**
     * 获取产品信息
     * @author by@Deng
     * @date 2018/1/25 下午6:29
     */
    @GetMapping("getProductEntityList")
    public Object getProductEntityList() throws Exception{

        List<Map<String,Object>> mapList = new ArrayList<>();
        List<ProductEntity> productEntityList = productService.findEntityList(null);
        for(ProductEntity productEntity:productEntityList){
            Map<String,Object> map = new HashMap<>();
            map.put("proName",productEntity.getProName());
            map.put("id",productEntity.getId());
            map.put("norm",productEntity.getNorm());
            map.put("proNum",productEntity.getProNum());
            map.put("cent",productEntity.getCent());
            map.put("costPrice",productEntity.getCostPrice());
            map.put("centPrice",productEntity.getCentPrice());
            map.put("remark",productEntity.getRemark());
            map.put("sortId",productEntity.getSortId());
            map.put("sortName",productSortService.findEntityByMainId(productEntity.getSortId()).getSortName());

            mapList.add(map);
        }

        return mapList;
    }




    /**
     * 获取某一个产品信息
     * @author by@Deng
     * @date 2018/1/25 下午6:29
     */
    @GetMapping("getProductEntityById")
    public Object getProductEntityById(@RequestParam String id) throws Exception{


        ProductEntity productEntity = productService.findEntityByMainId(id);
        Map<String,Object> map = new HashMap<>();
        map.put("proName",productEntity.getProName());
        map.put("id",productEntity.getId());
        map.put("norm",productEntity.getNorm());
        map.put("proNum",productEntity.getProNum());
        map.put("cent",productEntity.getCent());
        map.put("costPrice",productEntity.getCostPrice());
        map.put("centPrice",productEntity.getCentPrice());
        map.put("remark",productEntity.getRemark());
        map.put("sortId",productEntity.getSortId());
        map.put("sortName",productSortService.findEntityByMainId(productEntity.getSortId()).getSortName());



        return map;
    }



    /**
     * 更新产品信息
     * @author by@Deng
     * @date 2018/1/25 下午6:55
     */
    @PostMapping("updateProductEntity")
    public Object updateProductEntity(@RequestBody ProductEntity productEntity) throws Exception{
        return productService.updateEntity(productEntity);
    }

}
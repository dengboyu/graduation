package com.tt.association.module.ass.controller;

import com.tt.association.common.annotation.Result;
import com.tt.association.module.ass.entity.CompanyEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.tt.association.module.ass.service.CompanyService;


/**
* company表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-24 10:49:09
*/
@RestController
@RequestMapping("company")
@Result
public class CompanyController{

    @Resource
    private CompanyService companyService;



    /**
     * 添加公司
     * @author by@Deng
     * @date 2018/1/25 上午9:01
     */
    @PostMapping("insertCompanyEntity")
    public Object insertCompanyEntity(@RequestBody CompanyEntity companyEntity) throws Exception{
        return companyService.insertEntity(companyEntity);
    }


    /**
     * 查询已添加的公司
     * @author by@Deng
     * @date 2018/1/25 上午9:01
     */
    @GetMapping("getCompanyList")
    public Object getCompanyList() throws Exception{
        return companyService.findEntityList(null);
    }





}
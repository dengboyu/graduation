package com.tt.association.module.ass.controller;

import com.tt.association.common.annotation.Result;
import com.tt.association.module.ass.entity.CustomerEntity;
import com.tt.association.module.ass.service.CompanyService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.tt.association.module.ass.service.CustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
* customer表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-24 10:49:15
*/
@RestController
@RequestMapping("customer")
@Result
public class CustomerController{

    @Resource
    private CustomerService customerService;
    @Resource
    private CompanyService companyService;


    /**
     * 添加客户信息
     * @author by@Deng
     * @date 2018/1/25 下午2:32
     */
    @PostMapping("addCustomerEntity")
    public Object addCustomerEntity(@RequestBody CustomerEntity customerEntity) throws Exception{
        return customerService.insertEntity(customerEntity);
    }


    /**
     * 查找客户信息
     * @author by@Deng
     * @date 2018/1/25 下午4:39
     */
    @GetMapping("getCustomerList")
    public Object getCustomerList() throws Exception{

        List<Map<String,Object>> mapList = new ArrayList<>();

        List<CustomerEntity> customerEntityList = customerService.findEntityList(null);
        for(CustomerEntity customerEntity:customerEntityList){
            Map<String,Object> map = new HashMap<>();
            map.put("id",customerEntity.getId());
            map.put("companyId",customerEntity.getCompanyId());
            map.put("comName",companyService.findEntityByMainId(customerEntity.getCompanyId()).getComName());
            map.put("linkName",customerEntity.getLinkName());
            map.put("post",customerEntity.getPost());
            map.put("sex",customerEntity.getSex());
            map.put("phone",customerEntity.getPhone());
            map.put("tel",customerEntity.getTel());
            map.put("wwTel",customerEntity.getWwTel());
            map.put("fax",customerEntity.getFax());
            map.put("qq",customerEntity.getQq());
            map.put("msn",customerEntity.getMsn());
            map.put("email",customerEntity.getEmail());
            map.put("address",customerEntity.getAddress());
            map.put("remark",customerEntity.getRemark());

            mapList.add(map);
        }

        return  mapList;
    }




    /**
     * 查找客户信息
     * @author by@Deng
     * @date 2018/1/25 下午4:39
     */
    @GetMapping("getCustomerListById")
    public Object getCustomerListById(@RequestParam  String id) throws Exception{

        CustomerEntity customerEntity = customerService.findEntityByMainId(id);

        Map<String,Object> map = new HashMap<>();
        map.put("id",customerEntity.getId());
        map.put("companyId",customerEntity.getCompanyId());
        map.put("comName",companyService.findEntityByMainId(customerEntity.getCompanyId()).getComName());
        map.put("linkName",customerEntity.getLinkName());
        map.put("post",customerEntity.getPost());
        map.put("sex",customerEntity.getSex());
        map.put("phone",customerEntity.getPhone());
        map.put("tel",customerEntity.getTel());
        map.put("wwTel",customerEntity.getWwTel());
        map.put("fax",customerEntity.getFax());
        map.put("qq",customerEntity.getQq());
        map.put("msn",customerEntity.getMsn());
        map.put("email",customerEntity.getEmail());
        map.put("address",customerEntity.getAddress());
        map.put("remark",customerEntity.getRemark());

        return  map;
    }


    /**
     * 更新客户信息
     * @author by@Deng
     * @date 2018/1/25 下午5:29
     */
    @PostMapping("updateCustomerEntity")
    public Object updateCustomerEntity(@RequestBody CustomerEntity customerEntity) throws Exception{
        return customerService.updateEntity(customerEntity);
    }


}
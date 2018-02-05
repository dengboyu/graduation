package com.tt.association.module.ass.controller;

import com.tt.association.common.annotation.Result;
import com.tt.association.module.ass.entity.RemarkEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.tt.association.module.ass.service.RemarkService;


/**
* remark表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-24 10:49:41
*/
@RestController
@RequestMapping("remark")
@Result
public class RemarkController{

    @Resource
    private RemarkService remarkService;


    /**
     * 添加备注
     * @author by@Deng
     * @date 2018/1/25 下午5:53
     */
    @PostMapping("insertRemarkEntity")
    public Object insertRemarkEntity(@RequestBody RemarkEntity remarkEntity) throws Exception{
        return remarkService.insertEntity(remarkEntity);
    }


    /**
     * 查询备注
     * @author by@Deng
     * @date 2018/1/25 下午6:02
     */
    @GetMapping("getRemarkEntityList")
    public Object getRemarkEntityList() throws Exception{
        return remarkService.findEntityList(null);
    }


}
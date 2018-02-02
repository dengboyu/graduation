package com.leng.sguide.module.leung.service;

import com.leng.sguide.module.leung.entity.ScanTagEntity;
import com.leng.sguide.common.structure.service.BaseService;

import java.util.List;
import java.util.Map;


/**
* scan_tag表对应实体类的业务层接口
*
* @author by@Deng
* @create 2018-02-01 08:39:14
*/
public interface ScanTagService extends BaseService<ScanTagEntity> {


    /**
     * 根据账户获取浏览记录
     * @author by@Deng
     * @date 2018/2/2 下午9:21
     */
    List<Map<String,Object>> getScanTagEntityOrder(Integer id) throws Exception;

}
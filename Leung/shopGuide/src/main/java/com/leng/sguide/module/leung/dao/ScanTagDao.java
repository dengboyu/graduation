package com.leng.sguide.module.leung.dao;

import org.springframework.stereotype.Repository;
import com.leng.sguide.common.structure.dao.BaseDao;
import com.leng.sguide.module.leung.entity.ScanTagEntity;

import java.util.List;
import java.util.Map;


/**
* scan_tag表对应实体类
*
* @author by@Deng
* @create 2018-02-01 08:39:14
*/
@Repository
public interface ScanTagDao extends BaseDao<ScanTagEntity> {


    /**
     * 根据账户获取浏览记录
     * @author by@Deng
     * @date 2018/2/2 下午9:21
     */
    List<Map<String,Object>> getScanTagEntityOrder(Integer id) throws Exception;


}
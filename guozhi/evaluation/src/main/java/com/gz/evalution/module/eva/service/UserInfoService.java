package com.gz.evalution.module.eva.service;

import com.gz.evalution.module.eva.entity.UserInfoEntity;
import com.gz.evalution.common.structure.service.BaseService;

import java.util.List;
import java.util.Map;


/**
* user_info表对应实体类的业务层接口
*
* @author by@Deng
* @create 2018-01-19 11:16:52
*/
public interface UserInfoService extends BaseService<UserInfoEntity> {



    /**
     * 查找教师或者学生集合
     * @author by@Deng
     * @date 2018/1/20 下午4:20
     */
    List<Map<String,String>> getUserInfoList(String identity) throws Exception;



    /**
     * 根据id查找信息
     * @author by@Deng
     * @date 2018/1/22 下午11:52
     */
    Map<String,String> getUserInfoById(String id) throws Exception;
}
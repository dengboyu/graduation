package com.gz.evalution.module.eva.dao;

import org.springframework.stereotype.Repository;
import com.gz.evalution.common.structure.dao.BaseDao;
import com.gz.evalution.module.eva.entity.UserInfoEntity;

import java.util.List;
import java.util.Map;


/**
* user_info表对应实体类
*
* @author by@Deng
* @create 2018-01-19 11:16:52
*/
@Repository
public interface UserInfoDao extends BaseDao<UserInfoEntity> {


    /**
     * 查找教师或者学生集合
     * @author by@Deng
     * @date 2018/1/20 下午4:20
     */
    List<Map<String,String>>  getUserInfoList(String identity) throws Exception;


    /**
     * 根据id查找信息
     * @author by@Deng
     * @date 2018/1/22 下午11:52
     */
    Map<String,String> getUserInfoById(String id) throws Exception;
}
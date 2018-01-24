package com.gz.evalution.module.eva.serviceImpl;

import org.springframework.stereotype.Service;
import com.gz.evalution.module.eva.entity.UserInfoEntity;
import com.gz.evalution.module.eva.service.UserInfoService;
import com.gz.evalution.module.eva.dao.UserInfoDao;
import com.gz.evalution.common.structure.serviceAbstract.BaseServiceAbstract;

import java.util.List;
import java.util.Map;


/**
* user_info表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-01-19 11:16:52
*/
@Service
public class UserInfoServiceImpl extends BaseServiceAbstract<UserInfoDao,UserInfoEntity> implements UserInfoService {


    /**
     * 查找教师或者学生集合
     * @author by@Deng
     * @date 2018/1/20 下午4:22
     */
    @Override
    public List<Map<String, String>> getUserInfoList(String identity) throws Exception {
        return dao.getUserInfoList(identity);
    }



    /**
     * 根据id查找信息
     * @author by@Deng
     * @date 2018/1/22 下午11:52
     */
    @Override
    public Map<String, String> getUserInfoById(String id) throws Exception {
        return dao.getUserInfoById(id);
    }
}
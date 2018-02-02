package com.leng.sguide.module.leung.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.leng.sguide.module.leung.entity.ScanTagEntity;
import com.leng.sguide.module.leung.service.ScanTagService;
import com.leng.sguide.module.leung.dao.ScanTagDao;
import com.leng.sguide.common.structure.serviceAbstract.BaseServiceAbstract;

import java.util.List;
import java.util.Map;


/**
* scan_tag表对应实体类的业务层的实现类
*
* @author by@Deng
* @create 2018-02-01 08:39:14
*/
@Service
@Transactional
public class ScanTagServiceImpl extends BaseServiceAbstract<ScanTagDao,ScanTagEntity> implements ScanTagService {






    /**
     * 根据账户获取浏览记录
     * @author by@Deng
     * @date 2018/2/2 下午9:23
     */
    @Override
    public List<Map<String, Object>> getScanTagEntityOrder(Integer id) throws Exception {
        return dao.getScanTagEntityOrder(id);
    }
}
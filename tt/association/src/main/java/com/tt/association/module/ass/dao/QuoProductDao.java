package com.tt.association.module.ass.dao;

import com.tt.association.module.ass.entity.QuotationVo;
import org.springframework.stereotype.Repository;
import com.tt.association.common.structure.dao.BaseDao;
import com.tt.association.module.ass.entity.QuoProductEntity;
import org.springframework.web.bind.annotation.PostMapping;


/**
* quoProduct表对应实体类
*
* @author by@Deng
* @create 2018-01-24 10:49:32
*/
@Repository
public interface QuoProductDao extends BaseDao<QuoProductEntity> {



}
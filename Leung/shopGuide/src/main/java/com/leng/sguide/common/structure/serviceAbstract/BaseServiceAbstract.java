package com.leng.sguide.common.structure.serviceAbstract;

import com.leng.sguide.common.structure.dao.BaseDao ;
import com.leng.sguide.common.structure.service.BaseService ;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 实现BaseService的接口的基抽象类
 *
 * @author by@Deng
 * @create 2017-10-22 22:34
 */
public abstract class BaseServiceAbstract<D extends BaseDao<T> ,T> implements BaseService<T> {

    @Autowired
    protected D dao;

    /**
     * 添加一条记录
     * @author by@Deng
     * @date 2017/10/14 上午10:56
     */
    public Integer insertEntity(T t) throws Exception {
        return dao.insertEntity(t);
    }


    /**
     * 批量添加
     * @author by@Deng
     * @date 2017/10/20 下午11:16
     */
    public Integer insertEntityByBatch(List<T> t)throws Exception {
        return dao.insertEntityByBatch(t);
    }


    /**
     * 更新一条记录
     * @author by@Deng
     * @date 2017/10/14 上午10:59
     */
    public Integer updateEntity(T t)throws Exception {
        return dao.updateEntity(t);
    }


    /**
     * 根据主键删除
     * @author by@Deng
     * @date 2017/10/14 上午10:59
     */
    public Integer deleteEntity(Object id) throws Exception {
        return dao.deleteEntity(id);
    }


    /**
     * 根据主键查找
     * @author by@Deng
     * @date 2017/10/14 上午10:59
     */
    public T findEntityByMainId(Object id) throws Exception {
        return  dao.findEntityByMainId(id);
    }


    /**
     * 根据条件查出来是单条实体类
     * @author by@Deng
     * @date 2017/10/23 下午9:10
     */
    public T findEntityByOne(T t) throws Exception{
        return dao.findEntityByOne(t);
    }

    /**
     * 根据列条件查找实体类集合
     * @author by@Deng
     * @date 2017/10/14 上午11:06
     */
    public List<T> findEntityList(T t)throws Exception  {
        return dao.findEntityList(t);
    }


    /**
     * 查询记录数
     * @author by@Deng
     * @date 2017/10/23 下午9:10
     */
    public Long findEntityCount(T t) throws Exception {
        return dao.findEntityCount(t);
    }


    /**
     * 单表分页查询
     * @param map:开始行号
     * @author by@Deng
     * @date 2017/10/23 下午9:12
     */
    public List<T> findPageEntityList(Map<String,Object> map) throws Exception{
        return dao.findPageEntityList(map);
    }

    /**
     * 单表分页查询总共数量
     * @author by@Deng
     * @date 2017/10/23 下午9:12
     */
    public Long findPageEntityCount(Map<String, Object> map) throws Exception{
        return dao.findPageEntityCount(map);
    }

}

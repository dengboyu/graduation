package com.tt.association.common.structure.service;


import java.util.List;
import java.util.Map;

/**
 * 泛型service
 *
 * @author by@Deng
 * @create 2017-10-22 22:33
 */
public interface BaseService<T> {

    /**
     * 添加一条记录
     * @author by@Deng
     * @date 2017/10/14 上午10:56
     */
    Integer insertEntity(T t) throws Exception;

    /**
     * 批量添加
     * @author by@Deng
     * @date 2017/10/20 下午11:16
     */
    Integer insertEntityByBatch(List<T> t) throws Exception;

    /**
     * 更新一条记录
     * @author by@Deng
     * @date 2017/10/14 上午10:59
     */
    Integer updateEntity(T t) throws Exception;

    /**
     * 根据主键删除
     * @author by@Deng
     * @date 2017/10/14 上午10:59
     */
    Integer deleteEntity(Object id) throws Exception;

    /**
     * 根据主键查找
     * @author by@Deng
     * @date 2017/10/14 上午10:59
     */
    T findEntityByMainId(Object id) throws Exception;


    /**
     * 根据条件查出来是单条实体类
     * @author by@Deng
     * @date 2017/10/14 上午10:59
     */
    T findEntityByOne(T t) throws Exception;

    /**
     * 根据列条件查找实体类集合
     * @author by@Deng
     * @date 2017/10/14 上午11:06
     */
    List<T> findEntityList(T t) throws Exception;


    /**
     * 查询记录数
     * @author by@Deng
     * @date 2017/10/23 下午9:10
     */
    Long findEntityCount(T t) throws Exception;


    /**
     * 单表分页查询
     * @param map:开始行号
     *        rows: 查询多少条
     * @author by@Deng
     * @date 2017/10/23 下午9:12
     */
    List<T> findPageEntityList(Map<String, Object> map) throws Exception;


    /**
     * 单表分页查询总共数量
     * @author by@Deng
     * @date 2017/10/23 下午9:12
     */
    Long findPageEntityCount(Map<String, Object> map) throws Exception;

}

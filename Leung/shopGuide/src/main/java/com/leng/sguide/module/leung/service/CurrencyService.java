package com.leng.sguide.module.leung.service;

import java.util.Map;

/**
 * @author by@Deng
 * @create 2018-01-29 22:40
 */
public interface CurrencyService {


    /**
     * 获取分页参数
     * @author by@Deng
     * @date 2018/1/30 上午12:49
     */
    Map<String,Integer> getPageParam(Map<String,Object> map);

}

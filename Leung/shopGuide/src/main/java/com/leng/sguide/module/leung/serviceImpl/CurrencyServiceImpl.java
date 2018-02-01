package com.leng.sguide.module.leung.serviceImpl;

import com.leng.sguide.module.leung.service.CurrencyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by@Deng
 * @create 2018-01-30 00:49
 */
@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {


    /**
     * 获取分页参数
     * @author by@Deng
     * @date 2018/1/30 上午12:50
     */
    @Override
    public Map<String, Integer> getPageParam(Map<String, Object> map) {

        Map<String,Integer> retMap = new HashMap<>();

        Integer pageSize = Integer.valueOf(map.get("pageSize").toString());
        Integer pageStart= (Integer.valueOf(map.get("pageStart").toString())-1)*pageSize;

        retMap.put("pageSize",pageSize);
        retMap.put("pageStart",pageStart);
        return retMap;
    }
}

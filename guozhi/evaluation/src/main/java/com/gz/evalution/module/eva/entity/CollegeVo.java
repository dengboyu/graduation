package com.gz.evalution.module.eva.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author by@Deng
 * @create 2018-01-19 21:45
 */
public class CollegeVo extends CollegeEntity{

    private List<ProfessionEntity> professionEntityList;

    public List<ProfessionEntity> getProfessionEntityList() {
        return professionEntityList;
    }

    public void setProfessionEntityList(List<ProfessionEntity> professionEntityList) {
        this.professionEntityList = professionEntityList;
    }

    @Override
    public String toString() {
        return "CollegeVo{" +
                "professionEntityList=" + professionEntityList +
                '}';
    }
}

package com.gz.evalution.module.eva.controller;

import com.gz.evalution.common.annotation.Result;
import com.gz.evalution.common.exception.ByException;
import com.gz.evalution.module.eva.entity.QuestionEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.gz.evalution.module.eva.service.QuestionService;

import java.util.List;
import java.util.Map;


/**
* question表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-19 05:00:06
*/
@RestController
@RequestMapping("question")
@Result
public class QuestionController{

    @Resource
    private QuestionService questionService;




    /**
     * 增加问题
     * @author by@Deng
     * @date 2018/1/20 下午1:55
     */
    @PostMapping("insertQuestionBatch")
    public Object insertQuestionBatch(@RequestBody List<QuestionEntity> questionEntityList) throws Exception{
        if(questionEntityList==null || questionEntityList.size()<1) throw new ByException("请将信息填全");

        return questionService.insertEntityByBatch(questionEntityList);
    }


    /**
     * 获取所有信息
     * @author by@Deng
     * @date 2018/1/20 下午2:22
     */
    @GetMapping("getQuestionList")
    public Object getQuestionList()throws Exception{
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setStatu("1");
        return questionService.findEntityList(questionEntity);
    }


    /**
     * 更新问题
     * @author by@Deng
     * @date 2018/1/20 下午3:31
     */
    @PostMapping("updateQuestionById")
    public Object updateQuestionById(@RequestBody QuestionEntity questionEntity) throws Exception{
        return questionService.updateEntity(questionEntity);
    }


    /**
     * 删除问题
     * @author by@Deng
     * @date 2018/1/20 下午4:03
     */
    @PostMapping("deleteQuestion")
    public Object deleteQuestion(@RequestParam Integer id) throws Exception{
        if(id==null) throw new ByException("选择要删除的问题");

        return questionService.deleteEntity(id);
    }
}
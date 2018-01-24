package com.gz.evalution.module.eva.controller;

import com.gz.evalution.common.annotation.Result;
import com.gz.evalution.module.eva.entity.UserInfoEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.gz.evalution.module.eva.service.UserInfoService;

import java.util.List;
import java.util.Map;


/**
* user_info表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-19 05:00:12
*/
@RestController
@RequestMapping("userInfo")
@Result
public class UserInfoController{

    @Resource
    private UserInfoService userInfoService;


    /**
     * 添加学生或者教师
     * @author by@Deng
     * @date 2018/1/19 下午11:46
     */
    @PostMapping("addUserInfoEntity")
    public Object addUserInfoEntity(@RequestBody UserInfoEntity userInfoEntity) throws Exception{
        userInfoEntity.setStatu("1");
        return userInfoService.insertEntity(userInfoEntity);
    }


    /**
     * 获取学生或者教师信息
     * @author by@Deng
     * @date 2018/1/20 上午12:20
     */
    @GetMapping("getUserInfoEntity")
    public Object getUserInfoEntity(@RequestParam Map<String,String> map) throws Exception {
        UserInfoEntity userInfoEntity = new UserInfoEntity();

        if(StringUtils.equals(map.get("identity"),"1")){
            userInfoEntity.setIdentity(map.get("identity"));
        }

        return userInfoService.findEntityList(userInfoEntity);
    }




    /**
     * 查找教师或者学生集合
     * @author by@Deng
     * @date 2018/1/20 下午4:20
     */
    @GetMapping("getUserInfoList")
    public Object getUserInfoList(@RequestParam String identity) throws Exception{
        return userInfoService.getUserInfoList(identity);
    }


    /**
     * 更新信息集合
     * @author by@Deng
     * @date 2018/1/20 下午5:24
     */
    @PostMapping("updateUserInfoEntity")
    public Object updateUserInfoEntity(@RequestBody UserInfoEntity userInfoEntity) throws Exception{
        return userInfoService.updateEntity(userInfoEntity);
    }


    /**
     * 删除学生、教师信息
     * @author by@Deng
     * @date 2018/1/20 下午7:28
     */
    @PostMapping("deleteUserInfo")
    public Object deleteUserInfo(@RequestParam String id)throws Exception{
        return userInfoService.deleteEntity(id);
    }


    /**
     * 获取当前域信息
     * @author by@Deng
     * @date 2018/1/22 下午11:38
     */
    @GetMapping("getCurrentUserInfo")
    public Object getCurrentUserInfo() throws Exception{
        Subject subject = SecurityUtils.getSubject();
        return subject.getSession().getAttribute("currentUser");
    }





    /**
     * 根据id查找信息
     * @author by@Deng
     * @date 2018/1/22 下午11:52
     */
    @GetMapping("getUserInfoById")
    public Object getUserInfoById() throws Exception{
        Subject subject = SecurityUtils.getSubject();
        UserInfoEntity userInfoEntity = (UserInfoEntity) subject.getSession().getAttribute("currentUser");
        return userInfoService.getUserInfoById(userInfoEntity.getId().toString());
    }
}
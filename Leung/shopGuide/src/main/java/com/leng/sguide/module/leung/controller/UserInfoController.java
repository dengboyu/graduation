package com.leng.sguide.module.leung.controller;

import com.leng.sguide.common.annotation.Result;
import com.leng.sguide.module.leung.entity.UserInfoEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.leng.sguide.module.leung.service.UserInfoService;

import java.math.BigDecimal;


/**
* user_info表对应实体类的控制层
*
* @author by@Deng
* @create 2018-01-29 01:48:05
*/
@RestController
@RequestMapping("userInfo")
@Result
public class UserInfoController{

    @Resource
    private UserInfoService userInfoService;


    /**
     * 添加注册信息
     * @author by@Deng
     * @date 2018/1/29 下午1:49
     */
    @PostMapping("insertUserInfoEntity")
    public Object insertUserInfoEntity(@RequestBody UserInfoEntity userInfoEntity) throws Exception{
        if(userInfoEntity.getType().equals("1")){
            userInfoEntity.setCompanyPrice(new BigDecimal("0"));
        }
        return userInfoService.insertEntity(userInfoEntity);
    }


    /**
     * 获取域里信息
     * @author by@Deng
     * @date 2018/1/29 下午5:36
     */
    @GetMapping("getUserInfoEntity")
    public Object getUserInfoEntity() throws Exception{

        Object object = SecurityUtils.getSubject().getSession().getAttribute("currentUser");

        return object;
    }



    /**
     * 退出登录
     * @author by@Deng
     * @date 2018/1/29 下午5:36
     */
    @PostMapping("logout")
    public Object logout() throws Exception{

        SecurityUtils.getSubject().getSession().setAttribute("currentUser",null);
        return 1;
    }


    /**
     * 更新用户信息
     * @author by@Deng
     * @date 2018/1/29 下午6:16
     */
    @PostMapping("updateUserInfoEntity")
    public Object updateUserInfoEntity(@RequestBody UserInfoEntity userInfoEntity) throws Exception{
        userInfoService.updateEntity(userInfoEntity);

        SecurityUtils.getSubject().getSession().setAttribute("currentUser",userInfoEntity);
        return 1;
    }


}
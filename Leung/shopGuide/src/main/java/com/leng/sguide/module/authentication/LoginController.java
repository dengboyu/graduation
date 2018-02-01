package com.leng.sguide.module.authentication;

import com.leng.sguide.common.exception.ByException;
import com.leng.sguide.module.leung.entity.UserInfoEntity;
import com.leng.sguide.module.leung.service.UserInfoService;
import com.leng.sguide.utils.ResultDataUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by by@Deng on 2017/7/17.
 */
@Controller
public class LoginController {

    @Resource
    private UserInfoService userInfoService;

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/user/userLogin")
    @ResponseBody
    public Object userLogin(@RequestBody UserInfoEntity userInfoEntity, HttpServletRequest request) throws Exception {

        //获取当前主体的subject
        Subject subject = SecurityUtils.getSubject();

        if(!subject.isAuthenticated()){
            logger.info("通过了");
        }

        UserInfoEntity userInfoEntity1 = new UserInfoEntity();
        userInfoEntity1.setNick(userInfoEntity.getNick());
        List<UserInfoEntity> userInfoEntityList =  userInfoService.findEntityList(userInfoEntity1);
        if(userInfoEntityList.size()!=1 || !userInfoEntityList.get(0).getType().equals(userInfoEntity.getType()))throw  new ByException("登录名或密码错误");

        UsernamePasswordToken token = new UsernamePasswordToken(userInfoEntity.getNick(), userInfoEntity.getPassword());
        token.setRememberMe(true);

        try {
            logger.info("**********************************************");
            //其会自动委托给 SecurityManager.login 方法进行登录
            subject.login(token);
            logger.info("**********************************************");

        }catch(Exception e) {
            throw new ByException("登录名或密码错误");
        }



        //验证是否登录成功
        if(subject.isAuthenticated()){
            return ResultDataUtils.success(1);
        }else{
            token.clear();
        }
        return ResultDataUtils.success(0);
    }




}

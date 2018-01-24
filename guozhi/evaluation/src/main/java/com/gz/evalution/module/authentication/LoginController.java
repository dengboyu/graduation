package com.gz.evalution.module.authentication;

import com.gz.evalution.common.exception.ByException;
import com.gz.evalution.module.eva.entity.UserInfoEntity;
import com.gz.evalution.utils.ResultDataUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by by@Deng on 2017/7/17.
 */
@Controller
public class LoginController {
    
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/user/userLogin")
    @ResponseBody
    public Object userLogin(@RequestBody UserInfoEntity userInfoEntity) throws Exception {

        //获取当前主体的subject
        Subject subject = SecurityUtils.getSubject();

        if(!subject.isAuthenticated()){
            logger.info("通过了");
        }

        String username = userInfoEntity.getNumber();
        String password = userInfoEntity.getPassword();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);

        try {
            logger.info("**********************************************");
            logger.info(("对用户[" + username + "]进行登录验证..验证开始"));
            //其会自动委托给 SecurityManager.login 方法进行登录
            subject.login(token);
            logger.info("对用户[" + username + "]进行登录验证..验证通过");
            logger.info("**********************************************");

        }catch(Exception e){
            throw new ByException("登录名或密码错误");
        }
        //验证是否登录成功
        if(subject.isAuthenticated()){

            return ResultDataUtils.success(1);
        }else{
            token.clear();
        }
        return 0;
    }




}

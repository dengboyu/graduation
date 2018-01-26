package com.tt.association.module.authentication;

import com.tt.association.common.exception.ByException;
import com.tt.association.utils.ResultDataUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Object userLogin(@RequestParam Map<String,String> map) throws Exception {

        //获取当前主体的subject
        Subject subject = SecurityUtils.getSubject();

        if(!subject.isAuthenticated()){
            logger.info("通过了");
        }

        String username = map.get("username");
        String password = map.get("password");

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
        return ResultDataUtils.success(0);
    }




}

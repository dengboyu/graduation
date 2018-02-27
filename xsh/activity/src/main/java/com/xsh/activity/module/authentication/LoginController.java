package com.xsh.activity.module.authentication;

import com.xsh.activity.common.exception.ByException;
import com.xsh.activity.module.act.entity.SysUserEntity;
import com.xsh.activity.module.act.service.SysUserService;
import com.xsh.activity.utils.ResultDataUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by by@Deng on 2017/7/17.
 */
@Controller
public class LoginController {

    @Resource
    private SysUserService sysUserService;

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/user/userLogin")
    @ResponseBody
    public Object userLogin(@RequestParam Map<String,String> map, HttpServletRequest request) throws Exception {

        //获取当前主体的subject
         Subject subject = SecurityUtils.getSubject();

        String username = map.get("number");
        String password = map.get("password");

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setNumber(username);
        sysUserEntity.setPassword(password);

        sysUserEntity = sysUserService.findEntityByOne(sysUserEntity);
        if(sysUserEntity==null) throw new ByException("用户名或密码错误");


        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);

        try {
            logger.info("**********************************************");
            logger.info(("对用户[" + username + "]进行登录验证..验证开始"));
            //其会自动委托给 SecurityManager.login 方法进行登录
            subject.login(token);
            logger.info("对用户[" + username + "]进行登录验证..验证通过");
            logger.info("**********************************************");

        }catch(UnknownAccountException uae){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            request.setAttribute("message_login", "未知账户");
        }catch(IncorrectCredentialsException ice){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            request.setAttribute("message_login", "密码不正确");
        }catch(LockedAccountException lae){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            request.setAttribute("message_login", "账户已锁定");
        }catch(ExcessiveAttemptsException eae){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            request.setAttribute("message_login", "用户名或密码错误次数过多");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            request.setAttribute("message_login", "用户名或密码不正确");
        }
        //验证是否登录成功
        if(subject.isAuthenticated()){
            //登录认证通过,进行一些认证通过后的一些系统参数初始化操作



            return ResultDataUtils.success("1");
        }else{
            token.clear();
        }
        throw  new ByException("用户名或密码错误");
    }




}
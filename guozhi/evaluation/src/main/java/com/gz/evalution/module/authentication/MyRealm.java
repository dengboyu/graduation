package com.gz.evalution.module.authentication;


import com.gz.evalution.common.exception.ByException;
import com.gz.evalution.module.eva.entity.UserInfoEntity;
import com.gz.evalution.module.eva.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的指定Shiro验证用户登录的类
 * Created by by@Deng on 2017/7/16.
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 用户登陆认证
     * 该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     *
     * @param authcToken
     * @return
     * @throws
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        //获取基于用户名和密码的令牌
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        System.out.println("验证当前Subject获取到的用户名为:" + token.getUsername());

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setNumber(token.getUsername());
        try {
            List<UserInfoEntity> userInfoEntityList = userInfoService.findEntityList(userInfoEntity);
            if(userInfoEntityList.size()<1)throw new ByException("登录或密码错误");
            userInfoEntity = userInfoEntityList.get(0);
        } catch (Exception e) {
            throw new ByException("登录或密码错误");
        }

        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userInfoEntity.getNumber(),userInfoEntity.getPassword(), this.getName());
        this.setSession("currentUser", userInfoEntity);
        return authcInfo;

    }

    /**
     * 用户授权认证
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value){
        Subject subject = SecurityUtils.getSubject();
        if(null != subject){
            Session session = subject.getSession();
            if(null != session){
                session.setAttribute(key, value);
                session.setTimeout(60*30*1000);//会话登陆时间，优先级最高
            }
        }
    }


}


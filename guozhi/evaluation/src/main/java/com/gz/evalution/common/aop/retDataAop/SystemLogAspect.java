package com.gz.evalution.common.aop.retDataAop;

import com.gz.evalution.common.annotation.Result;
import com.gz.evalution.utils.ResultDataUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统日志记录
 *
 * @author by@Deng
 * @create 2017-12-11 14:09
 */
@Component
@Aspect
public class SystemLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    /**
     * Controller层切点
     * @author by@Deng
     * @date 2017/12/11 下午2:20
     */
    @Pointcut("execution(* com.gz.evalution.module.*.controller.*.*(..))")
    public void controllerAspect() {
    }


    /**
     * 前置通知--方法开始执行
     * @author by@Deng
     * @date 2017/12/10 下午10:03
     */
//    @Before("controllerAspect()")
    public void before(JoinPoint joinPoint){
        System.out.println("方法前执行,方法--->"+joinPoint.getSignature().getName());
    }

    /**
     * 后置通知--方法结束执行,异常也执行
     * @author by@Deng
     * @date 2017/12/10 下午10:04
     */
//    @After("controllerAspect()")
    public void after(){
        System.out.println("方法执行后立即执行");
    }

    /**
     * 环绕通知
     * @author by@Deng
     * @date 2017/12/10 下午10:03
     */
    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        //手动执行目标方法
        Object object = joinPoint.proceed();

        Class clazz= joinPoint.getTarget().getClass();  //获取当前执行的类
        if(clazz.isAnnotationPresent(Result.class)){
            return ResultDataUtils.success(object);
        }
        return object;
    }


    /**
     * 后置通知--方法结束后执行操作
     * @author by@Deng
     * @date 2017/12/10 下午10:03
     */
    @AfterReturning(value = "controllerAspect()",returning = "ret")
    public void doAfter(JoinPoint joinPoint, Object ret){

    }


}
package com.mubai.sync.aop;

import com.mubai.sync.bean.ResponseBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @author leitengfei
 */
@Order(7)
@Aspect
@Configuration
public class AspectLog {
    private final Log logger = LogFactory.getLog(AspectLog.class);

    @Around(value = "com.mubai.sync.aop.Pointcuts.actionCall()")
    public Object actionCallBefore(ProceedingJoinPoint point) throws Throwable {
        ResponseBean result = null;
        logger.info("interface:" + editLogContent4Begin(point));

        result = (ResponseBean) point.proceed();
        return result;
    }

    private String editLogContent4Begin(JoinPoint point) {
        StringBuilder sbLog = new StringBuilder(128);
        sbLog.append("Method ");
        sbLog.append(point.getSignature().getDeclaringTypeName());
        sbLog.append(".");
        sbLog.append(point.getSignature().getName());
        sbLog.append("() start. Parameters: {");
        sbLog.append(Arrays.toString(point.getArgs()));
        sbLog.append("}");
        return sbLog.toString();
    }

}

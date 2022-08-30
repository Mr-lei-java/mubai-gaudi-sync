package com.mubai.sync.config;


import com.mubai.sync.aop.AspectLog;
import com.mubai.sync.bean.ResponseBean;
import com.mubai.sync.enums.ConstantResultCode;
import com.mubai.sync.exception.BusinessException;
import com.mubai.sync.util.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author leitengfei
 */
@RestControllerAdvice(basePackages = {"com.mubai.sync.controller"})
public class GlobalExceptionHandler {
    private final Log logger = LogFactory.getLog(AspectLog.class);

    /**
     * Get方式参数验证异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseBean handleConstraintViolationException(ConstraintViolationException ex){
        // 获取所有错误信息
        HashSet<ConstraintViolation<?>> set = (HashSet<ConstraintViolation<?>>) ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = set.iterator();
        List<String> errorMsgList = new ArrayList<>();
        if(iterator.hasNext()){
            ConstraintViolation<?> next = iterator.next();
            // 只取一个异常信息返回
            String msg = next.getMessageTemplate();
            //返回自定义信息格式
            errorMsgList.add(msg);
        }
        ResponseBean result = new ResponseBean<>(ConstantResultCode.VALID_FAIL,errorMsgList);
        logger.warn(result);
        return result;
    }

    /**
     * 处理BindException异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseBean handleBindException(BindException ex){
        //获取所有错误异常
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

        List<String> errorMsgList = new ArrayList<>();
        FieldError fieldError = null;
        for (ObjectError error : allErrors) {
            if (error instanceof FieldError) {
                fieldError = (FieldError)error;
                if(fieldError.getRejectedValue() != null) {
                    errorMsgList.add(fieldError.getField() + "字段类型错误");
                } else {
                    errorMsgList.add(error.getDefaultMessage());
                }
            }else {
                errorMsgList.add(error.getDefaultMessage());
            }
        }
        //返回自定义信息格式
        ResponseBean result = new ResponseBean<>(ConstantResultCode.VALID_FAIL,errorMsgList);
        logger.warn(result);
        return result;
    }

    /**
     * POST方式参数验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseBean handleConstraintViolationException(MethodArgumentNotValidException ex){
        //获取所有错误异常
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        //只返回第一个信息
        List<String> errorMsgList = new ArrayList<>();
        for (ObjectError error : allErrors) {
            errorMsgList.add(error.getDefaultMessage());
        }
        //返回自定义信息格式
        ResponseBean result = new ResponseBean<>(ConstantResultCode.VALID_FAIL,errorMsgList);
        logger.warn(result);
        return result;
    }

    /**
     * 自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseBean handleBusinessException(BusinessException exp){
        ResponseBean result = new ResponseBean<>(exp.getCode(), exp.getMessage());
        if(exp.getCode().equals(ConstantResultCode.ERROR)) {
            logger.error(result);
            logger.error(ExceptionUtils.getStackTrace(exp));
        } else {
            logger.warn(result);
        }
        //返回自定义信息格式
        return result;
    }


    /**
     * 数据库数据为空时异常（getOne）
     */
    /*
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseBody
    public ResponseBean handleEmptyResultDataAccessException(EmptyResultDataAccessException exp){
        //返回自定义信息格式
        ResponseBean result = new ResponseBean<>(ConstantResultCode.VALID_FAIL, "数据不存在");

        fundebug.notifyError(exp);
        logger.warn(result);
        logger.warn(ExceptionUtils.getStackTrace(exp));

        return result;
    }
    */

    /**
     * 未知异常
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseBean handleThrowable(Throwable exp){
        if(exp instanceof TypeMismatchException) {
            return new ResponseBean<>(ConstantResultCode.VALID_FAIL, "参数类型不匹配");
        }
        if(exp instanceof HttpRequestMethodNotSupportedException) {
            return new ResponseBean<>(ConstantResultCode.VALID_FAIL, "请求方式错误");
        }
        if(exp instanceof MissingServletRequestParameterException) {
            return new ResponseBean<>(ConstantResultCode.VALID_FAIL, "输入参数不全");
        }
        if(exp instanceof HttpMessageNotReadableException) {
            return new ResponseBean<>(ConstantResultCode.VALID_FAIL, "参数格式不支持");
        }

        //返回自定义信息格式
        ResponseBean result = new ResponseBean<>(ConstantResultCode.ERROR, "未知异常，请联系管理员");
        logger.error(ExceptionUtils.getStackTrace(exp));

        return result;
    }
}

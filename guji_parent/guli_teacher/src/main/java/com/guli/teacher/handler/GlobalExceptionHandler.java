package com.guli.teacher.handler;

import com.guli.common.Result;
import com.guli.teacher.entity.EduException;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error().message("执行了异常处理");
    }

    @ExceptionHandler({EduException.class})
    public Result error(EduException e) {
        e.printStackTrace();
        return Result.error().code(e.getCode()).message(e.getMessage());
    }


}

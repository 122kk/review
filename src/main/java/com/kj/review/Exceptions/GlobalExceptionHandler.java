package com.kj.review.Exceptions;

import com.kj.review.Exceptions.CustomException;
import com.kj.review.Tools.R;
import com.kj.review.controller.UserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author kj
 * @date 2023/3/7
 * @apiNote 全局异常处理
 */
@ResponseBody
@RestControllerAdvice(annotations = {RestController.class})
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public R<String> NullExceptionHanler(NullPointerException nex){
        log.error("NullExceptionHandler:{}",nex.getStackTrace());
        log.error("LocalizedMessage:{}",nex.getLocalizedMessage());
        return R.success(500,"系统繁忙，请稍后再试！");
    }

    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException cex) {
        return R.error(500,cex.getMessage());
    }



}

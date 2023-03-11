package com.kj.review.Exceptions;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author kj
 * @date 2023/3/7
 * @apiNote 自定义异常处理
 */

public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}

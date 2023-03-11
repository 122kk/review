package com.kj.review.Interceptor;

import com.kj.review.Tools.JWTTockenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kj
 * @date 2023/3/4
 * @apiNote
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Jws<Claims> token = JWTTockenUtils.decode(request.getHeader("token"));
        // String id = token.getBody().get("id").toString();
        // //String userToken = JWTTockenUtils.decode(redisTemplate.opsForValue().get("userToken").toString()).getBody().get(id).toString();
        // String userToken = redisTemplate.opsForValue().get("userToken").toString();
        // Jws<Claims> decode = JWTTockenUtils.decode(userToken);
        // String userTokenId = decode.getBody().get("id").toString();
        //log.info("User token: {} ---- User==token: {} --- token==decode:{}",id.equals(userTokenId),userTokenId==id ,token==decode);
        if (request.getHeader("token").equals(redisTemplate.opsForValue().get("userToken"))){
            log.info("用户已登录！！！");
            return true;
        }

        log.info("用户未登陆！！！");
        return false;
    }
}

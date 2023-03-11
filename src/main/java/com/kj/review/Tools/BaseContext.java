package com.kj.review.Tools;

/**
 * @author kj
 * @date 2023/3/4
 * @apiNote 将创建或修改的user的id存入ThreadLocal
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<Long>();

    public static void setCreateUser(Long id){
        threadLocal.set(id);
    }

    public static Long getCreateUser(){
        return threadLocal.get();
    }
}

package com.kj.review.Entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */

@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建的时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改的时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 创建的用户名
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String createUser;

    /**
     * 修改的用户名
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateUser;


}
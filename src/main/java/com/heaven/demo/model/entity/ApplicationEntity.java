package com.heaven.demo.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 应用entity
 * @author zhangjian
 * @date 2019/05/07 11:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("t_edims_application")
public class ApplicationEntity {

    /**
     * 编号（主键）
     */
    @TableId(type = IdType.UUID)
    private String id;
    /**
     * 应用名称
     */
    private String applicationName;
    /**
     * 应用编码
     */
    private String applicationCode;
    /**
     * 是否单点登录(Y/N)
     */
    private String isSso;
    /**
     * 应用密码
     */
    private String applicationSecret;
    /**
     * 应用描述
     */
    private String applicationDesc;
    /**
     * 是否有效（Y:是 N:否）
     */
    private String active;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    /**
     * 创建人编号
     */
    private String createCode;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUser;
    /**
     * 修改人编号
     */
    private String updateCode;

}

package com.lirui.boat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单信息表
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @TableId(value = "id",type = IdType.UUID)
    private String id;

    /**
     * 父菜单id
     */
    @TableField("pid")
    private String pid;

    /**
     * 菜单名称
     */
    @TableField("name")
    private String name;

    /**
     * url地址
     */
    @TableField("url")
    private String url;

    /**
     * 菜单排序号
     */
    @TableField("num")
    private Integer num;

    /**
     * 菜单层级
     */
    @TableField("levels")
    private Integer levels;

    /**
     * 备注
     */
    @TableField("tips")
    private String tips;

    /**
     * 菜单状态 :  1:启用   0:不启用
     */
    @TableField("enable_status")
    private Integer enableStatus;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @TableField("last_edit_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastEditTime;


}

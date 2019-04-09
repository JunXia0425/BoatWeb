package com.lirui.boat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章信息表
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 信息id
     */
    @TableId(value = "id",type = IdType.UUID)
    private String id;

    /**
     * 发布者id,关联user.id
     */
    @TableField("editor_id")
    private String editorId;

    /**
     * 所属栏目id,关联menu.id
     */
    @TableField("menu_id")
    private String menuId;

    /**
     * 信息标题
     */
    @TableField("title")
    private String title;

    /**
     * 信息内容
     */
    @TableField("content")
    private String content;

    /**
     * 是否可用 1：可用，0：不可用
     */
    @TableField("enable_status")
    private Integer enableStatus;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @TableField("last_edit_time")
    private LocalDateTime lastEditTime;


}

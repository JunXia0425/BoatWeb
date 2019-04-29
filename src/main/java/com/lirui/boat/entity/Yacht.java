package com.lirui.boat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 游艇信息
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yacht")
public class Yacht implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id",type = IdType.UUID)
    private String id;

    /**
     * 游艇名称
     */
    @TableField("name")
    private String name;

    /**
     * 图片路径
     */
    @TableField("img_path")
    private String imgPath;

    /**
     * 艇长
     */
    @TableField("length")
    private Float length;

    /**
     * 产地
     */
    @TableField("region")
    private String region;

    /**
     * 年份
     */
    @TableField("year")
    private Integer year;

    /**
     * 售价
     */
    @TableField("price")
    private Float price;

    /**
     * 详情描述
     */
    @TableField("description")
    private String description;

    /**
     * 游艇所有者id,关联user.id
     */
    @TableField("owner_id")
    private String ownerId;

    /**
     * 是否可用 1：可用，0：不可用
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

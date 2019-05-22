package com.lirui.boat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品信息表
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 商品名称
     */
    @TableField("product_name")
    private String productName;

    /**
     * 商品类别，1：发电机，2：蓄电池，3：传感器
     */
    @TableField("type")
    private Integer type;

    /**
     * 商品描述
     */
    @TableField("description")
    private String description;

    /**
     * 商品图片的路径
     */
    @TableField("img_url")
    private String imgUrl;

    /**
     * 商品所有者id,关联user.id
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
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @TableField("last_edit_time")
    private LocalDateTime lastEditTime;

    /**
     * 产地
     */
    @TableField("region")
    private String region;


}

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
 * 商品信息表
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
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
    @TableId(value = "id",type = IdType.UUID)
    private String id;

    /**
     * 商品名称
     */
    @TableField("product_name")
    private String productName;

    /**
     * 商品类别，1：游艇，2：零件
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
    @TableField("ownner_id")
    private String ownnerId;

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

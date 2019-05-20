package com.lirui.boat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 航线表
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("route")
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 航线说明
     */
    @TableField("route_desc")
    private String routeDesc;

    /**
     * 价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 所属游艇id
     */
    @TableField("yacht_id")
    private String yachtId;


}

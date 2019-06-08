package com.lirui.boat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 游艇订单表
 * </p>
 *
 * @author Li Rui
 * @since 2019-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("yacht_order")
@NoArgsConstructor
public class YachtOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 游艇名称
     */
    @TableField("yacht_name")
    private String yachtName;

    /**
     * 价格
     */
    @TableField("price")
    private Float price;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 顾客姓名
     */
    @TableField("customer_name")
    private String customerName;

    /**
     * 游艇id
     */
    @TableField("yacht_id")
    private String yachtId;

    /**
     * 支付状态，0未支付，1 已支付
     */
    @TableField("status")
    private Integer status;

    /**
     * 订单创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    public YachtOrder(String yachtName, Float price, String phone, String customerName, String yachtId) {
        this.yachtName = yachtName;
        this.price = price;
        this.phone = phone;
        this.customerName = customerName;
        this.yachtId = yachtId;
    }
}

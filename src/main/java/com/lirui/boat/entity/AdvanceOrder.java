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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * 预定订单表
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("advance_order")
public class AdvanceOrder implements Serializable {


    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 游艇名称
     */
    @TableField("yacht_name")
    private String yachtName;

    /**
     * 出航日期
     */
    @TableField("trip_date")
    private LocalDate tripDate;

    /**
     * 出航时间
     */
    @TableField("trip_time")
    private LocalTime tripTime;

    /**
     * 航线，外键
     */
    @TableField("route")
    private String route;

    /**
     * 出行人数
     */
    @TableField("people_count")
    private Integer peopleCount;

    /**
     * 出行目的，外键
     */
    @TableField("trip_purpose")
    private String tripPurpose;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    @TableField("customer_name")
    private String customerName;

    /**
     * 性别 0：男，1：女
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 票据id，如果选择开票则存在一个id指向另外一张表
     */
    @TableField("invoice")
    private String invoice;

    /**
     * 游艇id
     */
    @TableField("yacht_id")
    private String yachtId;

    /**
     * 订单创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;


}

package com.lirui.boat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 票据信息表
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("invoice")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    /**
     * 发票抬头
     */
    @TableField("invoice_title")
    private String invoiceTitle;

    /**
     * 发票明细
     */
    @TableField("invoice_details")
    private String invoiceDetails;

    /**
     * 邮寄地址
     */
    @TableField("post_address")
    private String postAddress;

    /**
     * 邮政编码
     */
    @TableField("postcode")
    private String postcode;

    /**
     * 收件人
     */
    @TableField("addressee")
    private String addressee;

    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;


}

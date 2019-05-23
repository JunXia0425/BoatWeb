package com.lirui.boat.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 租赁游艇表
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leasing_yacht")
public class LeasingYacht implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 游艇id，外键
     */
    @TableId
    @TableField("yacht_id")
    private String yachtId;

    /**
     * 限载人数
     */
    @TableField("maxpeople")
    private Integer maxpeople;

    /**
     * 停靠码头（外键）
     */
    @TableField("wharf")
    private String wharf;

    /**
     * 游艇卧室数量
     */
    @TableField("bedroom")
    private Integer bedroom;

    /**
     * 标配船员
     */
    @TableField("standard_seaman")
    private String standardSeaman;

    /**
     * 标配项目
     */
    @TableField("standard_subject")
    private String standardSubject;

    /**
     * 选配项目
     */
    @TableField("apolegamy_subject")
    private String apolegamySubject;

    /**
     * 保险说明
     */
    @TableField("insurance_declare")
    private String insuranceDeclare;

    /**
     * 游艇隶属，如果拥有者不是管理员，隶属为私人，否则为企业；0:企业 1:私人
     */
    @TableField("belonging")
    private Integer belonging;


}

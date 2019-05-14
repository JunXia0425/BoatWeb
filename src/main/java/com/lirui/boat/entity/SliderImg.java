package com.lirui.boat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 轮播图片表
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("slider_img")
public class SliderImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private String id;

    /**
     * 轮播图路径
     */
    @TableField("path")
    private String path;

    /**
     * 图片次序，默认0
     */
    @TableField("num")
    private Integer num;


}

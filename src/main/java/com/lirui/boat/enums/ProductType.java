package com.lirui.boat.enums;

import lombok.Getter;

@Getter
public enum ProductType {
    /**
     * 游艇
     */
    ENGINE(1, "发电机"),
    /**
     * 零件
     */
    BATTERY(2, "蓄电池"),

    /**
     * 传感器
     */
    SENSOR(3, "传感器");

    private Integer type;
    private String desc;

    ProductType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}

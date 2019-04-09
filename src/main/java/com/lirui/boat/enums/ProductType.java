package com.lirui.boat.enums;

import lombok.Getter;

@Getter
public enum ProductType {
  /**
   * 游艇
   */
  YACHT(1,"游艇"),
  /**
   * 零件
   */
  ITEM(2,"零件");

  private Integer type;
  private String desc;

  ProductType(Integer type, String desc) {
    this.type = type;
    this.desc = desc;
  }
}

package com.lirui.boat.enums;

import lombok.Getter;

@Getter
public enum EnableStatus {
  /**
   * 启用状态，值为1
   */
  ABLE(1, "启用"),
  /**
   * 禁用状态，值为2
   */
  DISABLE(2, "禁用");

  private Integer value;
  private String desc;

  EnableStatus(Integer value, String desc) {
    this.value = value;
    this.desc = desc;
  }
}

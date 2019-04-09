package com.lirui.boat.enums;

import lombok.Getter;

@Getter
public enum Role {
  /**
   * 普通用户
   */
  USER(1, "用户"),
  /**
   * 管理员
   */
  ADMIN(2, "管理员"),
  /**
   * 超级管理员
   */
  SUPERADMIN(3, "超级管理员");


  private Integer userType;
  private String desc;

  Role(int userType, String desc) {
    this.userType = userType;
    this.desc = desc;
  }

}

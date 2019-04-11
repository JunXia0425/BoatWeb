package com.lirui.boat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lirui.boat.entity.vo.MenuVO;

/**
 * <p>
 * 菜单信息表 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
public interface MenuService extends IService<Menu> {
  /**
   * 分页查询栏目信息（连表查询查出上级栏目名称）
   * @param page 分页对象
   * @return
   */
  Page<MenuVO> page(Page<MenuVO> page);
}

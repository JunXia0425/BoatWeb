package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Menu;
import com.lirui.boat.entity.vo.MenuVO;
import com.lirui.boat.mapper.MenuMapper;
import com.lirui.boat.mapper.MenuMapper;
import com.lirui.boat.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单信息表 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
  @Autowired
  private MenuMapper menuMapper;

  @Override
  public Page<MenuVO> page(Page<MenuVO> page) {
    return page.setRecords(menuMapper.getMenus(page));
  }

  /**
   * 重写该方法实现删除父栏目同时删除子栏目
   * @param id
   * @return
   */
  @Override
  public boolean removeById(Serializable id) {
    QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
    queryWrapper.select("id").eq("pid",id);
    List<Menu> list = this.list(queryWrapper);
    for (Menu menu : list) {
      menuMapper.deleteById(menu.getId());
    }
    return super.removeById(id);
  }
}

package com.lirui.boat.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lirui.boat.entity.vo.ArticleVO;
import com.lirui.boat.entity.vo.MenuVO;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 菜单信息表 Mapper 接口
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
public interface MenuMapper extends BaseMapper<Menu> {
  /**
   * 连表查询栏目信息表和栏目信息表中的父级栏目名称
   * @param page 分页对象
   * @return 带有父级栏目名称的栏目列表
   */
  @Select("select s.*,f.name pname from menu s left join menu f on s.pid = f.id")
  List<MenuVO> getMenus(Page<MenuVO> page);
}

package com.lirui.boat.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Article;
import com.lirui.boat.entity.vo.ArticleVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 文章信息表 Mapper 接口
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

  /**
   * 连表查询文章信息表和用户信息表中的用户昵称
   *
   * @param page 分页对象
   * @return 带有编辑者昵称的文章列表
   */
  @Select("select a.*,u.nickname editor from article a join user u on a.editor_id = u.id")
  List<ArticleVO> getArticles(Page<ArticleVO> page);

  /**
   * 根据所属栏目连表查询文章信息表和用户信息表中的用户昵称
   *
   * @param page 分页对象
   * @param wrapper 查询条件
   * @return 带有编辑者昵称的指定栏目文章列表
   */
  List<ArticleVO> getArticlesInMenu(IPage<ArticleVO> page, @Param(value = "ew") QueryWrapper wrapper);


  List<ArticleVO> getArticles(Page<ArticleVO> page, @Param("ew") QueryWrapper queryWrapper);

}

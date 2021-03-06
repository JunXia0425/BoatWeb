package com.lirui.boat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lirui.boat.entity.Article;
import com.lirui.boat.entity.dto.ArticleDTO;
import com.lirui.boat.entity.vo.ArticleVO;

/**
 * <p>
 * 文章信息表 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
public interface ArticleService extends IService<Article> {
  /**
   * 分页查询文章信息（连表查询查出持有者昵称）
   * @param page 分页对象
   * @return
   */
  Page<ArticleVO> page(Page<ArticleVO> page);

  /**
   * 分页某个栏目下查询文章列表
   * @param page 分页对象
   * @param menuId 指定栏目id
   * @return
   */
  IPage<ArticleVO> page(IPage<ArticleVO> page, String menuId);

  /**
   * 分页按照指定参数查询文章列表
   * @param articleDTO 参数集合
   * @return
   */
  IPage<ArticleVO> page(ArticleDTO articleDTO);
}

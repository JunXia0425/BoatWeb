package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lirui.boat.entity.Article;
import com.lirui.boat.entity.dto.ArticleDTO;
import com.lirui.boat.entity.vo.ArticleVO;
import com.lirui.boat.mapper.ArticleMapper;
import com.lirui.boat.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章信息表 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
  @Autowired
  private ArticleMapper articleMapper;
  @Override
  public Page<ArticleVO> page(Page<ArticleVO> page) {
    return page.setRecords(articleMapper.getArticles(page));
  }


  @Override
  public IPage<ArticleVO> page(IPage<ArticleVO> page, String menuId) {
    return page.setRecords(articleMapper.getArticlesInMenu(page,menuId));
  }

  @Override
  public IPage<ArticleVO> page(ArticleDTO articleDTO) {
    QueryWrapper<ArticleVO> wrapper = new QueryWrapper<>();
    String keyWord = articleDTO.getKeyWord();
    Page<ArticleVO> articlePage = articleDTO.getArticlePage();
    String menuId = articleDTO.getMenuId();
    wrapper.like("content",keyWord).eq("menu_id",menuId).orderByDesc("last_edit_time");

    return articlePage.setRecords(articleMapper.getArticles(articlePage,wrapper));
  }
}

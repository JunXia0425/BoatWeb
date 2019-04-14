package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Article;
import com.lirui.boat.entity.vo.ArticleVO;
import com.lirui.boat.mapper.ArticleMapper;
import com.lirui.boat.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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


  public IPage<ArticleVO> page(IPage<ArticleVO> page, String menuId) {
    return page.setRecords(articleMapper.getArticlesInMenu(page,menuId));
  }

}

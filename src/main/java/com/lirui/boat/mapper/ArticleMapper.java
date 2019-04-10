package com.lirui.boat.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lirui.boat.entity.vo.ArticleVO;
import com.lirui.boat.entity.vo.ProductVO;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
   * @param page 分页对象
   * @return 带有编辑者昵称的文章列表
   */
  @Select("select a.*,u.nickname ownner from article a join user u on a.editor_id = u.id")
  List<ArticleVO> getArticles(Page<ArticleVO> page);
}

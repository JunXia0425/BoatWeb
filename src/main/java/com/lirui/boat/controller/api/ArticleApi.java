package com.lirui.boat.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Article;
import com.lirui.boat.entity.User;
import com.lirui.boat.entity.dto.ArticleDTO;
import com.lirui.boat.entity.vo.ArticleVO;
import com.lirui.boat.service.impl.ArticleServiceImpl;
import com.lirui.boat.service.impl.UserServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * ArticleApi
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-23
 */
@RestController
@RequestMapping("api/article")
public class ArticleApi {
    @Autowired
    private ArticleServiceImpl articleService;
    @Autowired
    private UserServiceImpl userService;

    /**
     * 分页条件查询符合栏目条件的所有文章，JSON格式返回
     */
    @PostMapping("/list/{menuId}")
    public ModelMap listArticle(@RequestBody Page<ArticleVO> articlePage,
                                @PathVariable("menuId") String id) {
        IPage<ArticleVO> page = articleService.page(articlePage, id);
        return ReturnUtil.success("ok", page, null);
    }

    /**
     * 分页条件查询符合关键字条件的所有文章，JSON格式返回
     */
    @PostMapping("/list/condition")
    public ModelMap listArticleByKeyWords(@RequestBody ArticleDTO articleDTO) {
        IPage<ArticleVO> page = articleService.page(articleDTO);
        return ReturnUtil.success("ok", page, null);
    }

    /**
     * 根据id查询对应文章并以JSON格式返回
     *
     * @param id 文章id
     * @return JSON对象
     */
    @PostMapping("/{articleId}")
    public ModelMap getArticle(@PathVariable("articleId") String id) {
        Article article = articleService.getById(id);
        String editorId = article.getEditorId();
        User byId = userService.getById(editorId);
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article,articleVO);
        if (byId != null) {
            articleVO.setEditor(byId.getNickname());
        }
        return ReturnUtil.success("ok", articleVO, null);
    }
}

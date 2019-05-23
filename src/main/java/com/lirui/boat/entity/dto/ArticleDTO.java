package com.lirui.boat.entity.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.vo.ArticleVO;
import lombok.Data;

/**
 * <p>
 * ArticleDTO
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-23
 */
@Data
public class ArticleDTO {
    private Page<ArticleVO> articlePage;
    private String menuId;
    private String keyWord;

}

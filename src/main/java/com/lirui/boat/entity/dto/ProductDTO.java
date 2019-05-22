package com.lirui.boat.entity.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.vo.ProductVO;
import lombok.Data;

/**
 * <p>
 * ProductDTO
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-22
 */
@Data
public class ProductDTO {
    private ProductQuery query;
    private Page<ProductVO> productPage;
}

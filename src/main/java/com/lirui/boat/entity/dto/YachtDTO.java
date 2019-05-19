package com.lirui.boat.entity.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.vo.YachtVO;
import lombok.Data;

/**
 * <p>
 * YachtDTO
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-19
 */
@Data
public class YachtDTO {

    private Page<YachtVO> yachtPage;
    private Query query;
}

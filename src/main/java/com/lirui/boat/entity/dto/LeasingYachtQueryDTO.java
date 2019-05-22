package com.lirui.boat.entity.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.vo.LeasingYachtVO;
import lombok.Data;

/**
 * <p>
 * LeasingYachtQuery
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-22
 */
@Data
public class LeasingYachtQueryDTO {
    private Query query;
    private Page<LeasingYachtVO> yachtPage;
}

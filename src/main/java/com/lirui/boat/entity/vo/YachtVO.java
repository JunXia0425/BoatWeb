package com.lirui.boat.entity.vo;

import com.lirui.boat.entity.Yacht;
import lombok.Data;

/**
 * <p>
 * YachtVO
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-28
 */
@Data
public class YachtVO extends Yacht {
    private String owner;
}

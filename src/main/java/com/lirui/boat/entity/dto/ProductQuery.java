package com.lirui.boat.entity.dto;

import lombok.Data;

/**
 * <p>
 * ProductQuery
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-22
 */
@Data
public class ProductQuery {
    private Range price;
    private Integer type;
    private String region;
}

package com.lirui.boat.entity.dto;

import lombok.Data;

/**
 * <p>
 * Query
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-19
 */
@Data
public class Query {

    private Range price;
    private Range length;
    private String classification;
    private String region;
    private String wharf;
}


package com.lirui.boat.entity.vo;

import com.lirui.boat.entity.LeasingYacht;
import com.lirui.boat.entity.Route;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * LeasingYachtVO
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-20
 */
@Data
public class LeasingYachtVO extends LeasingYacht {
    private String owner;
    private String name;
    private Float maxSpeed;
    private String path;
    private Float length;
    private String region;
    private String wharfName;
    private Integer stock;
    private List<Route> routes;
}

package com.lirui.boat.entity.dto;

import com.lirui.boat.entity.LeasingYacht;
import com.lirui.boat.entity.Route;
import com.lirui.boat.entity.Stock;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * LeasingYachtDTO
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-20
 */
@Data
public class LeasingYachtDTO {
    private Stock stock;
    private List<Route> routes;
    private LeasingYacht leasingYacht;
}

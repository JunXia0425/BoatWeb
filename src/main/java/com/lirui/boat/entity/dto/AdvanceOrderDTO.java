package com.lirui.boat.entity.dto;

import com.lirui.boat.entity.AdvanceOrder;
import com.lirui.boat.entity.Invoice;
import lombok.Data;

/**
 * <p>
 * AdvanceOrderDTO
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-21
 */
@Data
public class AdvanceOrderDTO {
    private AdvanceOrder advanceOrder;
    private Invoice invoice;
}

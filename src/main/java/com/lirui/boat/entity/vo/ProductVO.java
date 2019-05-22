package com.lirui.boat.entity.vo;

import com.lirui.boat.entity.Product;
import lombok.Data;

/**
 * <p>
 * ProductVO
 * </p>
 *
 * @author Li Rui
 * @since 2019/4/10
 */
@Data
public class ProductVO extends Product {
  private String owner;
}

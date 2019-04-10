package com.lirui.boat.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lirui.boat.entity.vo.ProductVO;
import java.util.List;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品信息表 Mapper 接口
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {

  /**
   * 连表查询商品表和用户信息表中的用户昵称
   * @param page 分页
   * @return
   */
  @Select("select p.*,u.nickname ownner from product p join user u on p.ownner_id = u.id")
  List<ProductVO> getProducts(Page<ProductVO> page);
}

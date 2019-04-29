package com.lirui.boat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lirui.boat.entity.Yacht;
import com.lirui.boat.entity.vo.YachtVO;

/**
 * <p>
 * 游艇信息 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-27
 */
public interface YachtService extends IService<Yacht> {
    /**
     * 分页查询商品信息（连表查询查出持有者昵称）
     * @param page 分页对象
     * @return
     */
    Page<YachtVO> page(Page<YachtVO> page);
}

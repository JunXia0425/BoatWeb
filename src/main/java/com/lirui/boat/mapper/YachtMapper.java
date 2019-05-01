package com.lirui.boat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Yacht;
import com.lirui.boat.entity.vo.YachtVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 游艇信息 Mapper 接口
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-27
 */
public interface YachtMapper extends BaseMapper<Yacht> {
    /**
     * 连表查询商品表和用户信息表中的用户昵称
     * @param page 分页
     * @return
     */
    @Select("select y.*,u.nickname owner from yacht y join user u on y.owner_id = u.id")
    List<YachtVO> getYachts(Page<YachtVO> page);
}
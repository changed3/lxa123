package com.team_three.project.mapper;

import com.team_three.project.entity.Flow;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
public interface FlowMapper extends BaseMapper<Flow> {
    void addFlow(Flow flow);
    List<Flow> selectAll(Integer fid);
}

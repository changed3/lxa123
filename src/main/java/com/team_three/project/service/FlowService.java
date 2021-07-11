package com.team_three.project.service;

import com.team_three.project.entity.Flow;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
public interface FlowService extends IService<Flow> {
    void addFlow(Flow flow);
    List<Flow> selectAll(Integer fid);

}

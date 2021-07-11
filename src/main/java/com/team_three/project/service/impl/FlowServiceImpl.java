package com.team_three.project.service.impl;

import com.team_three.project.entity.Flow;
import com.team_three.project.mapper.FlowMapper;
import com.team_three.project.service.FlowService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
@Service
public class FlowServiceImpl extends ServiceImpl<FlowMapper, Flow> implements FlowService {

    private FlowMapper mapper;

    @Autowired
    public void setMapper(FlowMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void addFlow(Flow flow) {
        mapper.addFlow(flow);
    }

    @Override
    public List<Flow> selectAll(Integer fid) {
       List<Flow> flows =  mapper.selectAll(fid);
        return flows;
    }
}

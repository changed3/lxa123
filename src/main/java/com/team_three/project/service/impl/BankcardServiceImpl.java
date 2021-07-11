package com.team_three.project.service.impl;

import com.team_three.project.entity.Bankcard;
import com.team_three.project.mapper.BankcardMapper;
import com.team_three.project.service.BankcardService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
@Service
public class BankcardServiceImpl extends ServiceImpl<BankcardMapper, Bankcard> implements BankcardService {


    private  BankcardMapper mapper;
    @Autowired
    public void setMapper(BankcardMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Bankcard findByBankcardId(Integer BankId) {
        return mapper.findByBankcardId(BankId);
    }

    @Override
    public void updateBankcard(Bankcard bankcard) {
        mapper.updateBankcard(bankcard);
    }


}

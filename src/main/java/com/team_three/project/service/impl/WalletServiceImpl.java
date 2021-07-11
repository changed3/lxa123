package com.team_three.project.service.impl;

import com.team_three.project.entity.Wallet;
import com.team_three.project.mapper.WalletMapper;
import com.team_three.project.service.WalletService;
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
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet> implements WalletService {

    private WalletMapper mapper;

    @Autowired
    public void setMapper(WalletMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Wallet findByWalletId(Integer WalletId) {
        return mapper.findByWalletId(WalletId);
    }

    @Override
    public void updateWallet(Wallet wallet) {
        mapper.updateWallet(wallet);
    }


}

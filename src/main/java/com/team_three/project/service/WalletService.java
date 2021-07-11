package com.team_three.project.service;

import com.team_three.project.entity.Wallet;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
public interface WalletService extends IService<Wallet> {
    Wallet findByWalletId(Integer WalletId);
    void updateWallet(Wallet wallet);
}

package com.team_three.project.mapper;

import com.team_three.project.entity.Wallet;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
public interface WalletMapper extends BaseMapper<Wallet> {
    Wallet findByWalletId(Integer WalletId);
    void updateWallet(Wallet wallet);
}

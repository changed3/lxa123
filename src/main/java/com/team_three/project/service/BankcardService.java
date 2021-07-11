package com.team_three.project.service;

import com.team_three.project.entity.Bankcard;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
public interface BankcardService extends IService<Bankcard> {
    Bankcard findByBankcardId(Integer BankId);

    void updateBankcard(Bankcard bankcard);
}

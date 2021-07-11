package com.team_three.project.mapper;

import com.team_three.project.entity.Bankcard;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.team_three.project.entity.Flow;
import com.team_three.project.entity.Wallet;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
public interface BankcardMapper extends BaseMapper<Bankcard> {
    /**充值业务
     * 根据id找到对应的银行卡
     * @param BankId
     * @return
     */
    Bankcard findByBankcardId(Integer BankId);

    void updateBankcard(Bankcard bankcard);


}

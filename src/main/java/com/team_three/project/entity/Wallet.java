package com.team_three.project.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_wallet")
public class Wallet extends Model<Wallet> {

    private static final long serialVersionUID = 1L;

    /**
     * 电子用户id(序号)
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 钱包id(和用户id连接)
     */
    private Integer walletId;
    /**
     * 账户余额
     */
    private BigDecimal walletMoney;
    /**
     * 用户钱包创建时间
     */
    private Date walletCreateTime;
    /**
     * 用户钱包更新时间(提现和充值)
     */
    private Date walletUpdateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

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
@TableName("t_bankcard")
public class Bankcard extends Model<Bankcard> {

    private static final long serialVersionUID = 1L;

    /**
     * 银行卡id(序号)
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 银行卡id(和用户id连接)
     */
    private Integer bankCardId;
    /**
     * 银行卡号
     */
    private String bankCardNumber;
    /**
     * 银行卡密码
     */
    private String bankCardPassword;
    /**
     * 银行卡余额
     */
    private BigDecimal bankCardMoney;
    /**
     * 银行卡被绑定的身份证
     */
    private String bankCardIdCard;
    /**
     * 银行卡类型(0：中央银行，1：中国农业银行，2：中国建设建行，3：交通银行，4：中国工商银行，5：中国邮政储蓄银行)
     */
    private Integer bankCardType;
    /**
     * 银行卡创建时间
     */
    private Date bankCardCreateTime;
    /**
     * 银行卡更新时间
     */
    private Date bankCardUpdateTime;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

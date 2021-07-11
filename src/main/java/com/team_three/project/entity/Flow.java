package com.team_three.project.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.UUID;

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
@TableName("t_flow")
public class Flow extends Model<Flow> {

    private static final long serialVersionUID = 1L;

    /**
     * 流水id(序号)
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 流水id(和用户id进行关联)
     */
    private Integer flowId;
    /**
     * 业务单号(UUID创建)
     */
    private String flowOrderNumber;
    /**
     * 用户名
     */
    private String flowUserName;
    /**
     * 流水金额
     */
    private BigDecimal flowMoney;
    /**
     * 业务内容(0：充值，1：提现，2：转账)
     */
    private Integer flowType;
    /**
     *  银行卡号
     */
    private String flowBankNumber;
    /**
     * 当前状态(0：失败，1：成功)
     */
    private Integer flowStatus;
    /**
     * 创建时间
     */
    private Date flowCreateTime;

    public Flow(Integer flowId, String flowUserName, BigDecimal flowMoney, Integer flowType, String flowBankNumber, Integer flowStatus) {
        this.flowId = flowId;
        this.flowUserName = flowUserName;
        this.flowMoney = flowMoney;
        this.flowType = flowType;
        this.flowBankNumber = flowBankNumber;
        this.flowStatus = flowStatus;
        this.flowCreateTime = new Timestamp(new Date().getTime());
        this.flowOrderNumber = UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

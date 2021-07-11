package com.team_three.project.test;

import com.team_three.project.entity.Bankcard;
import com.team_three.project.entity.Flow;
import com.team_three.project.service.BankcardService;
import com.team_three.project.service.FlowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class RechargeTest {
    private BankcardService service;
    private FlowService flowService;

    @Autowired
    public void setFlowService(FlowService flowService) {
        this.flowService = flowService;
    }

    @Autowired
    public void setService(BankcardService service) {
        this.service = service;
    }

    /**
     * 完全ok
     */
    @Test
   public void recharge(){
        Bankcard bankcard = service.findByBankcardId(1);
//        System.out.println(bankcard);
        bankcard.setBankCardMoney(bankcard.getBankCardMoney().subtract(new BigDecimal(10)));
        service.updateBankcard(bankcard);
   }

   @Test
   public void select(){
        List<Flow> flows = flowService.selectAll(1);
        flows.forEach(flow -> {
            System.out.println(flow);
        });
    }
}

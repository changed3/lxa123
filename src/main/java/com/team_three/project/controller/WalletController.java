package com.team_three.project.controller;


import com.team_three.project.entity.Bankcard;
import com.team_three.project.entity.Flow;
import com.team_three.project.entity.User;
import com.team_three.project.entity.Wallet;
import com.team_three.project.service.BankcardService;
import com.team_three.project.service.FlowService;
import com.team_three.project.service.UserService;
import com.team_three.project.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
@Controller
@RequestMapping("/wallet")
public class WalletController {
    /**
     提现
     */
    private WalletService walletService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public WalletController(FlowService flowService) {
        this.flowService = flowService;
    }

    @Autowired
    public void setWalletService(WalletService service) {
        walletService = service;
    }

    private BankcardService bankcardService;
    @Autowired
    public void setBankService(BankcardService service) {
        bankcardService = service;
    }

    private FlowService flowService;
    @Autowired
    public void setFlowService(FlowService service) {
        flowService = service;
    }

    @RequestMapping(value = "/Withdraw",method = RequestMethod.GET)
    public String Recharge(Integer id,ModelMap modelMap){
        User user = userService.selectById(id);
        modelMap.addAttribute("user",user);
        return "/wallet/withdraw.jsp";
    }

    @RequestMapping(value = "/withdraw")
    public String withdraw(Integer id,String username, BigDecimal money, ModelMap map) {

        // 钱包余额减少
        Wallet wallet = walletService.findByWalletId(id);
       /* if(wallet.getWalletMoney()== null){
            return "redirect:/withdraw";
        }*/
        wallet.setWalletMoney(wallet.getWalletMoney().subtract(money));
        walletService.updateWallet(wallet);

//        银行卡金额增加
        User user = userService.selectById(id);
        map.addAttribute("login_success",user);
        Bankcard bankcard = bankcardService.findByBankcardId(id);
        bankcard.setBankCardMoney(bankcard.getBankCardMoney().add(money));
        bankcardService.updateBankcard(bankcard);
        Flow rechargeFlow = new Flow(id,username,new BigDecimal(String.valueOf(money)),0,bankcard.getBankCardNumber()
                ,1);
        // 流水生成
        flowService.addFlow(rechargeFlow);

        return "/index.jsp";
    }

}


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
@RequestMapping("/bankcard")
public class BankcardController {
    /**
     * 充值
     */
    private BankcardService bankcardService;
    private WalletService walletService;
    private FlowService flowService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBankcardService(BankcardService bankcardService) {
        this.bankcardService = bankcardService;
    }

    @Autowired
    public void setFlowService(FlowService flowService) {
        this.flowService = flowService;
    }

    @Autowired
    public void setWalletService(WalletService walletService) {
        this.walletService = walletService;
    }

    @RequestMapping(value = "/wallet",method = RequestMethod.GET)
    public String wallet(Integer id,ModelMap modelMap){
        User user = userService.selectById(1);
        Wallet wallet = walletService.selectById(1);
        modelMap.addAttribute("wallet",wallet);
        return "wallet.jsp";
    }

    /**
     * 充值
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/Recharge",method = RequestMethod.GET)
    public String Recharge(Integer id,ModelMap modelMap){
        User user = userService.selectById(id);
        modelMap.addAttribute("user",user);
        return "recharge.jsp";
    }


    //充值
    @RequestMapping(value = "/recharge",method = RequestMethod.POST)
    public String recharge(Integer id,String username, BigDecimal money,ModelMap modelMap){

         Bankcard bankcard = bankcardService.findByBankcardId(id);

         bankcard.setBankCardMoney(bankcard.getBankCardMoney().subtract(money));
         bankcardService.updateBankcard(bankcard);
         Wallet wallet = walletService.findByWalletId(id);
         wallet.setWalletMoney(wallet.getWalletMoney().add(money));
           User user = userService.selectById(id);
         walletService.updateWallet(wallet);
         Flow rechargeFlow = new Flow(id,username,new BigDecimal(String.valueOf(money)),0,bankcard.getBankCardNumber()
        ,1);
         flowService.addFlow(rechargeFlow);
         modelMap.addAttribute("login_success",user);
        return "/index.jsp";
    }
}


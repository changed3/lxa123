package com.team_three.project.controller;


import com.team_three.project.entity.Flow;
import com.team_three.project.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 第三组
 * @since 2021-04-30
 */
@Controller
@RequestMapping("/flow")
public class FlowController {

    private FlowService service;

    @Autowired
    public void setService(FlowService service) {
        this.service = service;
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public String selectAll(Integer id, ModelMap modelMap){
        List<Flow> flows = service.selectAll(id);
        modelMap.addAttribute("flows",flows);
        return "flows.jsp";
    }
}


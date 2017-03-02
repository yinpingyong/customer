package cn.com.bestpay.customer.controller;

import cn.com.bestpay.customer.service.ServerModel;
import cn.com.bestpay.server.model.request.LoginRequest;
import cn.com.bestpay.server.model.response.LoginResponse;
import cn.com.bestpay.server.model.response.base.CommonResponse;
import cn.com.bestpay.server.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/3/2.
 */
@Slf4j
@Controller
public class LoginController {

    /**
     * 基于配置方式，获取dubbo对象
     * @param username
     * @param password
     * @return
     */
   /* @Autowired
    @Qualifier("loginService")
    private LoginService loginService;*/

   @Autowired
   @Qualifier("serverModel")
   private ServerModel serverModel;

    @RequestMapping(value =  "/login" )
    public ModelAndView login(String username, String password) {

        ModelAndView mav = new ModelAndView();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setName(username);
        loginRequest.setPassword(password);

        CommonResponse<LoginResponse>  commonResponse = serverModel.loginService.LoginService(loginRequest);
        mav.addObject("commonResponse",commonResponse.toString());

        mav.setViewName("main");

        return mav;
    }
}

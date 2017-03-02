package cn.com.bestpay.customer.controller;

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

    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @RequestMapping(value =  "/login" )
    public ModelAndView login(String username, String password) {

        ModelAndView mav = new ModelAndView();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setName(username);
        loginRequest.setPassword(password);

        CommonResponse<LoginResponse>  commonResponse = loginService.LoginService(loginRequest);
        mav.addObject("commonResponse",commonResponse.toString());

        mav.setViewName("main");

        return mav;
    }
}

package cn.com.bestpay.customer.service;

import cn.com.bestpay.server.service.LoginService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * 建议使用一个Class，定义一个被模块的所有Service对象
 *
 * Created by Administrator on 2017/3/2.
 */
@Component("serverModel")
public class ServerModel {

    /**
     * 使用Dubbo自动注入Bean
     */
    @Reference(registry="customerRegistry",consumer="consumerServer")
    public LoginService loginService;

}

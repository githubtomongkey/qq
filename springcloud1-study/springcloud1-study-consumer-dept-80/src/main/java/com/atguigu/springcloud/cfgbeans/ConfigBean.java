package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//boot --spring  applicationContext.xml   ----@Configuration配置
//这样就等价于 applicationContext.xml中的 <bean id="" class=""
@Configuration
public class ConfigBean {


    /*
    * RestTemplate提供了多种便捷访问远程Http服务的方法,是一种简单便捷的访问restful服务模板类,
    * 是Spring提供的用于访问Rest服务的客户端模板工具集
    * */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }


    @Bean
    public IRule myRule(){
       return new RandomRule();
    }
}

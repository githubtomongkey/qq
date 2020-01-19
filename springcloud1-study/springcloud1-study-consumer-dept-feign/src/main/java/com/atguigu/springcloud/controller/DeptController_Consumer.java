package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    /**
     * 使用restTemplate访问restful接口非常的简单粗暴无脑.
     * (url,requestMap,ResponseBean.class)这三个参数分别代表
     * REST请求地址,请求参数,HTTP响应转换被转换成的对象类型.
     */
    private static final String REST_URL_PREFIX="http://STUDY-SPRINGCLOUD1-DEPT";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeptClientService deptClientService;

    @PostMapping(value = "/consumer/dept/add")
  public boolean add( @RequestBody Dept dept){
       return restTemplate.postForObject( REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
//        return restTemplate.postForObject( "http://localhost:8001/dept/add", dept, Boolean.class);

    }

    @RequestMapping("/consumer/dept/findById/{deptNo}")
    public Dept findById(@PathVariable(value = "deptNo") Long deptNo){
     /*   //三个参数：url,requestMap ResponseBean.class
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/findById/"+deptNo,
                Dept.class);*/
     return deptClientService.findById(deptNo);
    }

    @RequestMapping("/consumer/dept/findAll")
    public List findAll(){
    return  deptClientService.findAll();
    }


    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(
                REST_URL_PREFIX+"/dept/discovery",
                Object.class);
    }

}

package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept findById(Long deptNo) {
                return new Dept().setDeptno(deptNo).setDname("该ID"+deptNo+"没有对应的信息,Consumer客户端提供的降级服务");
            }

            @Override
            public List findAll() {
                return null;
            }
        };
    }
}

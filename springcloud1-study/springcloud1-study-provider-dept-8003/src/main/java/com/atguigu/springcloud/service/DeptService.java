package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {
        /**
         * 插入
         * @param dept
         * @return
         */
        public boolean addDept(Dept dept);
        /**
         * 根据id查找
         * @param id
         * @return
         */
        public Dept findById(Long id);
        /**
         * 查询全部
         * @return
         */
        public List<Dept> findAll();

}

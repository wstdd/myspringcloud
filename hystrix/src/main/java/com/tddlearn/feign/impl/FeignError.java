package com.tddlearn.feign.impl;

import com.tddlearn.entity.Student;
import com.tddlearn.feign.FeignProviderClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器维护中………";
    }
}

package com.tddlearn.controller;

import com.tddlearn.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;
    String url="http://provider/student/";

    @GetMapping("findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity(url+"findAll",Collection.class).getBody();
    }

    @GetMapping("index")
    public String index(){
        return restTemplate.getForEntity(url+"index",String.class).getBody();
    }
}

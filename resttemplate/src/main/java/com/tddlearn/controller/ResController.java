package com.tddlearn.controller;

import com.tddlearn.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class ResController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String port;

    @Value("${foo}")
    private String foo;

    String url="http://localhost:8010/student/";
    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity(url+"findAll",Collection.class).getBody();
    }

    @GetMapping("findById/{id}")
    public  Student findById(@PathVariable("id") long id){
        return restTemplate.getForObject(url+"findById/{id}",Student.class,id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForObject(url+"save",student,Student.class);
    }
    @PostMapping("/save2")
    public void save2(@RequestBody Student student){
        restTemplate.postForEntity(url+"save",student,null);
    }
    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put(url+"update",student);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        restTemplate.delete(url+"deleteById/{id}",id);
    }

    @GetMapping("/index")
    public String index(){
        return this.port+"-"+this.foo;
    }

}

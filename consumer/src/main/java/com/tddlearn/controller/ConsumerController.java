package com.tddlearn.controller;

import com.tddlearn.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

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

}

package com.kim.dani.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j

public class HelloController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/hello/{userid}")
    public String mapping1(@PathVariable("userid")String id){
      log.info("udserid={}",id);
        System.out.println(id);
        return "success";
    }

}

package com.gaogao.houduan.controller;

import com.gaogao.houduan.entity.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/json")
public class JsonController {
    @RequestMapping("/test")
    public Test getTest(){
        return new Test(1,"ss","ww");
    }
    @RequestMapping("/list")
    public List<Test> getTlist(){
        List<Test> lst=new ArrayList<>();
        Test t1=new Test(2,"22","222");
        Test t2=new Test(3,"23","333");
        lst.add(t1);
        lst.add(t2);
        return lst;
    }
}

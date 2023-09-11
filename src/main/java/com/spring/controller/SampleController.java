package com.spring.controller;

import com.spring.domain.SampleDTO;
import com.spring.domain.SampleDTOList;
import com.spring.domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Log4j
@Controller
// default url path
@RequestMapping("/sample/*")
public class SampleController {

    @RequestMapping
    public void basic() {
        log.info("basic...............");
    }

    @RequestMapping(value = "/basic",method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {
        log.info("basic get...............");
    }

    @GetMapping("/basicOnlyGet")
    public void basicGet2() {
        log.info("basic get only get...............");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info("SampleDTO = " + dto);
        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
        log.info("name = " + name);
        log.info("age = " + age);
        return "ex02";
    }

    // ?ids=111&ids=222&ids=333
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
        log.info("ids = " + ids);
        return "ex02List";
    }

    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids) {
        log.info("array ids = " + ids);
        return "ex02Array";
    }

    // ?list[0].name=aaa&list[2].name=bbb
    // ?list%5B0%5D.name=aaa&list%5B2%5D.name=bbb
    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos = " + list);
        return "ex02Bean";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }

    // InitBinder 방식
    // ?title=test&dueDate=2018-01-01
    // DateTimeFormat 방식 (InitBinder 주석처리)
    // ?title=test&dueDate=2018/01/01
    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        // String to java.util.Date
        log.info("todo = " + todo);
        return "ex03";
    }

    // ?name=aaa&age=11&page=9
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, int page) {
        log.info("dto = " + dto);
        log.info("page = " + page);
        return "/sample/ex04";
    }
}

package com.spring.controller;

import com.spring.domain.SampleDTO;
import com.spring.domain.SampleDTOList;
import com.spring.domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

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
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto = " + dto);
        log.info("page = " + page);
        return "/sample/ex04";
    }

    // void 타입은 url경로를 view로 처리하기 때문에 ex05.jsp가 없을 경우 에러
    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05............");
    }

    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06() {
        log.info("/ex06............");
        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("hong gil-dong");
        return dto;
    }

    @GetMapping("/ex07")
    public ResponseEntity<String> ex07() {
        log.info("/ex07............");

        String msg = "{\"name\": \"홍길동\"}";
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }

    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("/exUpload................");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        files.forEach(file -> {
            log.info("----------------------------------------");
            log.info("name:" + file.getOriginalFilename());
            log.info("size:" + file.getSize());
        });
    }
}

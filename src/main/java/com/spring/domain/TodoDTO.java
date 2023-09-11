package com.spring.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TodoDTO {

    private String title;

    // InitBinder를 사용하지 않고 포맷 방식을 명시해줌.
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dueDate;

}

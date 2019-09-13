package com.volunt.message.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class Member {

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Birthday;

    private String HomeAddress;
    private String  College;//学院
    private String Profession;//专业
    private String Dormitory;//宿舍住址 ;  丁香1-Ⅱ-329
    private Integer main_id;
    private Integer departid;


}

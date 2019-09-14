package com.volunt.message.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class Member {

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String homeAddress;
    private String  college;//学院
    private String profession;//专业
    private String dormitory;//宿舍住址 ;  丁香1-Ⅱ-329
    private Integer main_id;
    private Integer departid;
    private String memberName;

}

package com.volunt.message.model;



import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;



@Data
@ToString
@ExcelTarget("memberEntity")
public class Member implements java.io.Serializable{


    @Excel(name = "main_id",orderNum = "0",type = 10)
    private Integer main_id;

    @Excel(name = "姓名",orderNum = "1")
    private String memberName;

    @Excel( name = "性别" ,orderNum = "2")
    private String sex;

    @Excel(name = "学号",orderNum = "3")
    private String studentNum;//学号

    @Excel(name = "生日",orderNum = "4", databaseFormat = "yyyyMMdd", format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;

    @Excel(name = "电话",orderNum = "5")
    private String telNum;

    @Excel(name = "家庭住址",orderNum = "6")
    private String homeAddress;

    @Excel(name = "学院",orderNum = "7")
    private String  college;//学院

    @Excel(name = "专业",orderNum = "8")
    private String profession;//专业

    @Excel(name = "宿舍",orderNum = "9")
    private String dormitory;//宿舍住址 ;  丁香1-Ⅱ-329

    private String department;

}

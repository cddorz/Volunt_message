package com.volunt.message.controller;

import com.volunt.message.service.MemberMessage;

import com.volunt.message.tools.UniversalResponseBody;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Date;


@RestController
public class MemMessage {

    @Resource
    MemberMessage memberMessage;
    @Resource
    UniversalResponseBody universalResponseBody;


    @PostMapping("/InsertMessage")
    public String Insert(@RequestParam("homeAddress") String homeAddress, @RequestParam("main_id")Integer main_id, @RequestParam(value = "birthday",required = false)Date birthday, @RequestParam("college")String college, @RequestParam("profession")String profession, @RequestParam("dormitory")String dormitory){

        if (memberMessage.InsertMemberMess(homeAddress,college,profession,birthday,dormitory,main_id)!=0){
            return "SUCCESS";
        }else{
            return "ERROR";
        }
    }


}

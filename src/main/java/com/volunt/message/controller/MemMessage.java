package com.volunt.message.controller;

import com.volunt.message.service.GetMessage;
import com.volunt.message.service.MemberMessage;

import com.volunt.message.tools.UniversalResponseBody;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Date;



@RestController
public class MemMessage {

    @Resource
    MemberMessage memberMessage;
    GetMessage getMessage;


    @PostMapping("/InsertMessage")
    public UniversalResponseBody Insert(@RequestParam("homeAddress") String homeAddress, @RequestParam("main_id")Integer main_id, @RequestParam(value = "birthday",required = false)Date birthday, @RequestParam("college")String college, @RequestParam("profession")String profession, @RequestParam("dormitory")String dormitory,@RequestParam("name")String name,@RequestParam("departid")Integer departid) {

         return  memberMessage.InsertMemberMess(homeAddress, college, profession, birthday, dormitory, main_id, name,departid);
    }

    @GetMapping("/Get/M embers")
    public UniversalResponseBody GetMember(@RequestParam("departid")Integer departid){
        return getMessage.getByDepartID(departid);
    }
}

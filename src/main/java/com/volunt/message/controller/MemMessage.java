package com.volunt.message.controller;

import com.volunt.message.service.MemberMessage;

import com.volunt.message.tools.UniversalResponseBody;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class MemMessage {

    @Resource
    MemberMessage memberMessage;
//    @Resource
//    UniversalResponseBody universalResponseBody;


    @PostMapping("/InsertMessage")
    public UniversalResponseBody Insert(@RequestParam("homeAddress") String homeAddress, @RequestParam("main_id")Integer main_id, @RequestParam(value = "birthday",required = false)Date birthday, @RequestParam("college")String college, @RequestParam("profession")String profession, @RequestParam("dormitory")String dormitory,@RequestParam("name")String name) {

        try{
            if (memberMessage.InsertMemberMess(homeAddress, college, profession, birthday, dormitory, main_id,name) != 0) {
                Map map =new HashMap();
                map.put("homeAddress",homeAddress);
                map.put("main_id",main_id);
                map.put("college",college);
                map.put("profession",profession);
                map.put("birthday",birthday);
                map.put("dormitory",dormitory);
                map.put("name",name);
                return new UniversalResponseBody<>(201,"成功",map);

            } else {
                return new UniversalResponseBody<>(400,"失败",null);
            }
        }catch (Exception e){
            System.out.println("成员信息录入发生错误");
            return new UniversalResponseBody<>(400,"失败",null);
        }
    }


}

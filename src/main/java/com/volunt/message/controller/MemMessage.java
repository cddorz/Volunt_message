package com.volunt.message.controller;

import com.github.pagehelper.PageInfo;
import com.volunt.message.service.impl.MemberServiceImpl;

import com.volunt.message.tools.UniversalResponseBody;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Date;


@Slf4j
@RestController
public class MemMessage {

    @Resource
    private MemberServiceImpl memberMessage;


    @PostMapping("/InsertMessage")
    public UniversalResponseBody Insert(@RequestParam("homeAddress") String homeAddress, @RequestParam("main_id")Integer main_id, @RequestParam(value = "birthday",required = false)Date birthday, @RequestParam("college")String college, @RequestParam("profession")String profession, @RequestParam("dormitory")String dormitory,@RequestParam("name")String name,@RequestParam("departid")Integer departid) {
        log.info(homeAddress);
        return  memberMessage.InsertMemberMess(homeAddress, college, profession, birthday, dormitory, main_id, name,departid);
    }

    @GetMapping("/GetMembers")
    public PageInfo GetMember(@RequestParam("departid") Integer departid, @RequestParam("pageNum")int pageNum, @RequestParam("pageSize")int pageSize){

        log.info(departid+"");
        return memberMessage.getByDepartID(departid,pageNum,pageSize);

    }
}

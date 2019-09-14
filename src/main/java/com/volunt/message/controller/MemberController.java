package com.volunt.message.controller;

import com.github.pagehelper.PageInfo;
import com.volunt.message.model.Member;
import com.volunt.message.service.impl.MemberServiceImpl;

import com.volunt.message.tools.UniversalResponseBody;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import java.util.Date;


@Slf4j
@RestController
public class MemberController {

    @Resource
    private MemberServiceImpl memberMessage;

//
    @PostMapping("/InsertMessage")
    public UniversalResponseBody Insert(@NotNull Member member) {
        log.info(member.toString());
        return  memberMessage.InsertMemberMess(member);
    }

    @GetMapping("/GetMembers")
    public PageInfo GetMember(@RequestParam("departid") Integer departid, @RequestParam("pageNum")int pageNum, @RequestParam("pageSize")int pageSize){
        return memberMessage.getByDepartID(departid,pageNum,pageSize);

    }
}

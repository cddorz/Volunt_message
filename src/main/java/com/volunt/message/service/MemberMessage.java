package com.volunt.message.service;

import com.volunt.message.dao.InsertMember;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class MemberMessage {
    @Resource
    InsertMember insertMember;


    public int InsertMemberMess(String homeAddress, String college, String profession, Date birthday, String dormitory, Integer main_id,String name){
        return insertMember.InsertMember(homeAddress,college,profession,birthday,dormitory,main_id,name);
    }
}

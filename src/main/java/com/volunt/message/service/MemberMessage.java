package com.volunt.message.service;

import com.volunt.message.dao.InsertMember;
import com.volunt.message.tools.UniversalResponseBody;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class MemberMessage {
    @Resource
    InsertMember insertMember;


    public UniversalResponseBody InsertMemberMess(String homeAddress, String college, String profession, Date birthday, String dormitory, Integer main_id,String name){
        try{
            if (insertMember.InsertMember(homeAddress, college, profession, birthday, dormitory, main_id,name) != 0) {
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

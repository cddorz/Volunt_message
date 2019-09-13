package com.volunt.message.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.volunt.message.mapper.MemberMessages;
import com.volunt.message.model.Member;
import com.volunt.message.service.MemberService;
import com.volunt.message.tools.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMessages memberMessages;


    public UniversalResponseBody InsertMemberMess(String homeAddress, String college, String profession, Date birthday, String dormitory, Integer main_id,String name,Integer departid){
        try{
            if (memberMessages.InsertMember(homeAddress, college, profession, birthday, dormitory, main_id,name,departid)!=0) {
                Map map =new HashMap();
                map.put("homeAddress",homeAddress);
                map.put("main_id",main_id);
                map.put("college",college);
                map.put("profession",profession);
                map.put("birthday",birthday);
                map.put("dormitory",dormitory);
                map.put("name",name);
                map.put("departid",departid);
                return new UniversalResponseBody<>(0,"成功",map);

            } else {
                return new UniversalResponseBody<>(-1,"失败",null);
            }
        }catch (Exception e){
            return new UniversalResponseBody<>(-1,"失败",null);
        }
    }



    public PageInfo getByDepartID(Integer departid,int pageNum,int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Member> pageInfo = new PageInfo<>(memberMessages.SelectByDepartID(departid));
        return pageInfo;
    }
}

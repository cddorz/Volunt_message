package com.volunt.message.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.volunt.message.mapper.MemberMessageMapper;
import com.volunt.message.model.Member;
import com.volunt.message.service.MemberService;
import com.volunt.message.tools.UniversalResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMessageMapper memberMessageMapper;


    public UniversalResponseBody InsertMemberMess(Member member){
        try{
            if (memberMessageMapper.InsertMember(member)>0) {

                return new UniversalResponseBody<>(0,"成功",member);

            } else {
                return new UniversalResponseBody<>(-1,"失败",null);
            }
        }catch (Exception e){
            log.error(""+e);
            return new UniversalResponseBody<>(-1,"失败");
        }
    }



    public PageInfo getByDepartID(Integer departid,int pageNum,int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Member> pageInfo = new PageInfo<>(memberMessageMapper.SelectByDepartID(departid));
        return pageInfo;
    }
}

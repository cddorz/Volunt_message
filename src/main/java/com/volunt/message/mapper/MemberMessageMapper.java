package com.volunt.message.mapper;

import com.github.pagehelper.Page;
import com.volunt.message.model.Member;


public interface MemberMessageMapper {

    int InsertMember(Member member);

    Page<Member> SelectByDepartID(Integer departid);
}
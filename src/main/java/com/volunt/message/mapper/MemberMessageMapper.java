package com.volunt.message.mapper;

import com.github.pagehelper.Page;
import com.volunt.message.model.Member;

import java.util.List;


public interface MemberMessageMapper {

    int InsertMember(Member member);

    Page<Member> SelectByDepartment(String department);

    List<Member> SelectForExcel(String department);
}

package com.volunt.message.service;

import com.github.pagehelper.PageInfo;
import com.volunt.message.model.Member;
import com.volunt.message.tools.UniversalResponseBody;

import java.util.Date;
import java.util.List;

public interface MemberService {
     UniversalResponseBody InsertMemberMess(Member member);

     UniversalResponseBody getByDepartID(String department, int pageNum, int pageSize);

     List<Member> getForExcel(String department);
}

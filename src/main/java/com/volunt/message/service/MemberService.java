package com.volunt.message.service;

import com.github.pagehelper.PageInfo;
import com.volunt.message.model.Member;
import com.volunt.message.tools.UniversalResponseBody;

import java.util.Date;

public interface MemberService {
     UniversalResponseBody InsertMemberMess(Member member);

        PageInfo<Member> getByDepartID(Integer departid, int pageNum, int pageSize);
}

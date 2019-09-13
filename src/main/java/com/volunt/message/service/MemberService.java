package com.volunt.message.service;

import com.github.pagehelper.PageInfo;
import com.volunt.message.model.Member;
import com.volunt.message.tools.UniversalResponseBody;

import java.util.Date;

public interface MemberService {
     UniversalResponseBody InsertMemberMess(String homeAddress, String college, String profession, Date birthday, String dormitory, Integer main_id, String name, Integer departid);

        PageInfo<Member> getByDepartID(Integer departid, int pageNum, int pageSize);
}

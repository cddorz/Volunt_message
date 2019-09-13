package com.volunt.message.mapper;

import com.github.pagehelper.Page;
import com.volunt.message.model.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface MemberMessages {

    @Insert("insert into membermessage (HomeAddress, College, Profession, Birthday, Dormitory,main_id,Name,departid) VALUES(#{HomeAddress},#{College},#{Profession},#{Birthday},#{Dormitory},#{main_id},#{Name},#{departid})")
    int InsertMember(String HomeAddress, String College, String Profession, Date Birthday, String Dormitory, Integer main_id,String Name,Integer departid);

    @Select("select * from membermessage WHERE departid = #{deparid}")
    Page<Member> SelectByDepartID(Integer departid);

}

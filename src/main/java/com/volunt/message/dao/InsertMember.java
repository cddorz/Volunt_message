package com.volunt.message.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;


@Mapper
public interface InsertMember {

    @Insert("insert into membermessage (HomeAddress, College, Profession, Birthday, Dormitory,main_id,Name) VALUES(#{HomeAddress},#{College},#{Profession},#{Birthday},#{Dormitory},#{main_id},#{Name})")
    int InsertMember(String HomeAddress, String College, String Profession, Date Birthday, String Dormitory, Integer main_id,String Name);
}

package com.volunt.message.controller;

import com.github.pagehelper.PageInfo;
import com.volunt.message.enums.DepartmentEnum;
import com.volunt.message.model.Member;
import com.volunt.message.service.impl.MemberServiceImpl;

import com.volunt.message.tools.UniversalResponseBody;

import com.volunt.message.util.ExcelUtil;
import com.volunt.message.util.Object2Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
public class MemberController {

    @Resource
    private MemberServiceImpl memberMessageService;


    /**
     *
     * @param member
     * @return 0 成功并返回插入时的数据 -1 失败
     */
    @PostMapping("/InsertMessage")
    public UniversalResponseBody Insert(@NotNull Member member) {
        log.info(member.toString());
        return  memberMessageService.InsertMemberMess(member);
    }

    /**
     *
     * @param departmentCode
     * @param pageNum
     * @param pageSize
     * @return 分页返回部门所有人员
     */
    @GetMapping("/GetMembers")
    public PageInfo GetMember(@RequestParam("departCode")int departmentCode, @RequestParam("pageNum")int pageNum, @RequestParam("pageSize")int pageSize){
        String department = DepartmentEnum.getDepartment(departmentCode);
        return memberMessageService.getByDepartID(department,pageNum,pageSize);
    }

    /**
     *
     * @param departmentCode
     * @param response
     * 导出该部门所有部员详细信息
     */
    @GetMapping("/export/messages/{departmentCode}")
    public void exportMessages(@PathVariable("departmentCode")int departmentCode, HttpServletResponse response){
        //获取部门名称
        String department = DepartmentEnum.getDepartment(departmentCode);

        List<Map<String,Object>> memberList = Object2Map.object2MapList(memberMessageService.getForExcel(department));
        ExcelUtil.templateExportExcel("/root/message"+"/MemberMessageTemp.xls",memberList,department+"部员详细信息.xls",response);

    }
}

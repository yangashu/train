package com.trkj.train.mapper;

import com.trkj.train.entity.SysStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-18
 */
public interface SysStaffMapper extends BaseMapper<SysStaff> {
    SysStaff findByid(@Param("id") int id);
    //    班级管理的添加班级弹框中的   班主任下拉框查询
    @Select("SELECT *\n" +
            "            FROM sys_staff_position sp\n" +
            "            LEFT JOIN SYS_STAFF s on sp.STAFF_ID=s.staff_Id\n" +
            "            LEFT JOIN sys_position p on sp.position_id=p.position_id\n" +
            "            WHERE p.position_name='班主任'")
    List<SysStaff> selectstaff();
    //  咨询登记页面   跟进人下拉框查询
    @Select("SELECT *\n" +
            "            FROM sys_staff_position sp\n" +
            "            LEFT JOIN SYS_STAFF s on sp.STAFF_ID=s.staff_Id\n" +
            "            LEFT JOIN sys_position p on sp.position_id=p.position_id\n" +
            "            WHERE p.position_name='咨询师'")
    List<SysStaff> selectgjr();
//    学员中心   在读学员   上课老师下拉框查询
@Select("SELECT *" +
        "                  FROM sys_staff_position sp\n" +
        "                 LEFT JOIN SYS_STAFF s on sp.STAFF_ID=s.staff_Id\n" +
        "               LEFT JOIN sys_position p on sp.position_id=p.position_id\n" +
        "                   WHERE p.position_name='上课老师'")
    List<SysStaff> selectclassteacher();

//教程入库  添加弹框 采购员下拉框查询
    @Select("SELECT *\n" +
            "       FROM sys_staff_position sp\n" +
            "       LEFT JOIN SYS_STAFF s on sp.STAFF_ID=s.staff_Id\n" +
            "       LEFT JOIN sys_position p on sp.position_id=p.position_id\n" +
            "\t\t\t WHERE p.position_name='财务'")
    List<SysStaff> selectcgy();

}

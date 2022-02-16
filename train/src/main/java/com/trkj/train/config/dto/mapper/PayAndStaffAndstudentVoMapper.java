package com.trkj.train.config.dto.mapper;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.train.config.dto.vo.PayAndStaffAndstudentVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface PayAndStaffAndstudentVoMapper extends BaseMapper<PayAndStaffAndstudentVo> {
    @Select("SELECT * FROM finance_pay p " +
            " LEFT JOIN \n" +
            " sys_staff s ON p.staff_id= s.STAFF_ID\n" +
            " LEFT JOIN\n" +
            " recruit_student stu ON p.student_id=stu.STUDENT_ID ${ew.customSqlSegment}")
    IPage<PayAndStaffAndstudentVo> paging(IPage page, @Param(Constants.WRAPPER) Wrapper<PayAndStaffAndstudentVo> queryWrapper);

    @Update("update FINANCE_PAY set INCOME_STATE=0 where paymoney_id=#{id}")
    int updatebyid(@Param("id") Integer id);

    @Select("SELECT * FROM finance_pay p " +
            " LEFT JOIN " +
            " sys_staff s ON p.staff_id= s.STAFF_ID " +
            " LEFT JOIN " +
            " recruit_student stu ON p.student_id=stu.STUDENT_ID where p.paymoney_id=#{id}")
    List<PayAndStaffAndstudentVo> selectbyid(@Param("id") Integer id);
}

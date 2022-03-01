package com.trkj.train.config.dto.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.train.config.dto.vo.RefundAndLeaveSchoolAndStudentAndStaffVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RefundAndLeaveSchoolAndStudentAndStaffMapper extends BaseMapper<RefundAndLeaveSchoolAndStudentAndStaffVo> {
    @Select("select * from ect_refund r" +
            " left join ect_leaveSchool l" +
            " on r.leaveSchool_id=l.leaveSchool_id" +
            " left join recruit_student stu" +
            " on l.student_id=stu.student_id" +
            " LEFT JOIN ect_classes cla" +
            " ON stu.classes_id=cla.classes_id"+
            " left JOIN SYS_STAFF sta" +
            " ON cla.staff_id=sta.staff_id ${ew.customSqlSegment}")
    IPage<RefundAndLeaveSchoolAndStudentAndStaffVo> paging(IPage page, @Param(Constants.WRAPPER) Wrapper<RefundAndLeaveSchoolAndStudentAndStaffVo> queryWrapper);

    @Update("update finance_expenditure set payApproval_state=0 where expenditure_id=#{id}")
    int updatebyid(Integer id);

    @Select("select * from ect_refund r" +
            " left join ect_leaveSchool l" +
            " on r.leaveSchool_id=l.leaveSchool_id" +
            " left join recruit_student stu" +
            " on l.student_id=stu.student_id" +
            " LEFT JOIN ect_classes cla" +
            " ON stu.classes_id=cla.classes_id"+
            " left JOIN SYS_STAFF sta" +
            " ON cla.staff_id=sta.staff_id where r.refund_id=#{id}")
    RefundAndLeaveSchoolAndStudentAndStaffVo findByid(@Param("id") String traceNo);
}

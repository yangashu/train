package com.trkj.train.config.dto.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.trkj.train.config.dto.vo.ExpenditureAndRefundAndPurchaseAndStaffVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface ExpenditureAndRefundAndPurchaseAndStaffMapper extends BaseMapper<ExpenditureAndRefundAndPurchaseAndStaffVo> {
    @Select("SELECT * FROM finance_expenditure e"+
            " LEFT JOIN finance_purchase p ON e.purchase_id=p.purchase_id"+
            " LEFT JOIN ect_refund r ON e.refund_id=r.refund_id"+
            " LEFT JOIN sys_staff s ON e.staff_id=s.staff_id"+
            " LEFT JOIN sys_staff s1 ON e.drawing=s1.staff_id ${ew.customSqlSegment}")
    IPage<ExpenditureAndRefundAndPurchaseAndStaffVo> paging(IPage page, @Param(Constants.WRAPPER) Wrapper<ExpenditureAndRefundAndPurchaseAndStaffVo> queryWrapper);

    @Update("update finance_expenditure set payApproval_state=0 where expenditure_id=#{id}")
    int updatebyid(Integer id);
}

package com.trkj.train.config.dto.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Refund")
@ApiModel(value="RefundAndLeaveSchoolAndStudentAndStaffVo对象", description="")
@ExcelTarget("学员退费")
public class RefundAndLeaveSchoolAndStudentAndStaffVo implements Serializable {
    @TableId("REFUNDID")
    private Integer refundId;

    @Excel(name = "退费时间",format = "yyyy年MM月dd日 HH时mm分ss秒")
    @TableField("REFUND_DATE")
    private Date refundDate;
    @Excel(name = "退费金额",suffix = "￥")
    @TableField("REFUND_MONEY")
    private Integer refundMoney;

    @TableField("STAFF_ID")
    private Integer staffId;


    @TableField("STAFF_NAME")
    private String staffName;

    @Excel(name = "状态")
    @TableField("REFUND_STATE")
    private Integer refundState;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @Excel(name = "申请退费学员")
    @TableField("STUDENT_NAME")
    private String studentName;

    @TableField("LEAVESCHOOL_ID")
    private Integer leaveschoolId;

    @Excel(name = "申请日期")
    @TableField("LEAVESCHOOL_DATE")
    private Date leaveschoolDate;

    @Excel(name = "退费明细")
    @TableField("LEAVESCHOOL_REASON")
    private String leaveschoolReason;

    @Excel(name = "经办人")
    @TableField("PERSONAL_NAME")
    private String personalName;
}

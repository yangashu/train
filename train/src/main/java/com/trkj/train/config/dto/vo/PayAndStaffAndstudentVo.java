package com.trkj.train.config.dto.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.*;
import com.trkj.train.entity.RecruitStudent;
import com.trkj.train.entity.SysStaff;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 *
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FINANCE_PAY")
@ApiModel(value="PayAndStaffAndstudentVo对象", description="")
@ExcelTarget("学员退费")
public class PayAndStaffAndstudentVo implements Serializable {
    @TableId("PAYMONEY_ID")
    private Integer paymoneyId;

    @Excel(name = "缴费金额",suffix = " ￥")
    @TableField("PAYMONEY_MONEY")
    private Integer paymoneyMoney;

    @Excel(name = "缴费时间",format = "yyyy年MM月dd日 HH时mm分ss秒")
    @TableField("PAYMONEY_DATE")
    private Date paymoneyDate;

    @Excel(name = "缴费方式")
    @TableField("PAYMONEY_MODE")
    private String paymoneyMode;

    @Excel(name = "交易状态",replace = {"已到账_0","未到账_1"})
    @TableField("INCOME_STATE")
    private Integer incomeState;


    @Excel(name = "录入人")
    @TableField("STAFF_NAME")
    private String staffName;

    @Excel(name = "缴费学员")
    @TableField("STUDENT_NAME")
    private String studentName;
}

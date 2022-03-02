package com.trkj.train.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FINANCE_PAY")
@ApiModel(value="FinancePay对象", description="")
@KeySequence(value = "pay_seq")
@ExcelTarget("FinancePays")
public class FinancePay implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    @TableId(value = "PAYMONEY_ID",type = IdType.INPUT)
    private Integer paymoneyId;

    @Excel(name = "缴费金额",suffix = " ￥")
    @TableField("PAYMONEY_MONEY")
    private Integer paymoneyMoney;

    @Excel(name = "缴费时间",format = "yyyy年MM月dd日 HH时mm分ss秒")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("PAYMONEY_DATE")
    private Date paymoneyDate;

    @Excel(name = "缴费方式")
    @TableField("PAYMONEY_MODE")
    private String paymoneyMode;

    @ExcelIgnore
    @TableField("COURSE_ID")
    private Integer courseId;

    @ExcelIgnore
    @TableField("STAFF_ID")
    private Integer staffId;

    @ExcelIgnore
    @TableField("STUDENT_ID")
    private Integer studentId;

    @Excel(name = "交易状态",replace = {"已到账_0","未到账_1"})
    @TableField("INCOME_STATE")
    private Integer incomeState;

    @ExcelIgnore
    @TableField("DELETED")
    private Integer deleted;


    @ExcelEntity
    @TableField(exist = false)
    private SysStaff staff;

    @ExcelEntity
    @TableField(exist = false)
    private RecruitStudent student;

}

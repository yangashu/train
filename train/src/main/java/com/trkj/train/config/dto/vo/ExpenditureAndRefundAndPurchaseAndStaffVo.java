package com.trkj.train.config.dto.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
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
@TableName("finance_expenditure")
@ApiModel(value="ExpenditureAndRefundAndPurchaseAndStaff对象", description="")
@ExcelTarget("校务支出")
public class ExpenditureAndRefundAndPurchaseAndStaffVo implements Serializable {


    @TableId("EXPENDITURE_ID")
    private Integer expenditureId;

    @Excel(name = "支出金额",suffix = "￥")
    @TableField("EXPENDITURE_MONEY")
    private Integer expenditureMoney;

    @Excel(name = "支出日期",format = "yyyy年MM月dd日 HH时mm分ss秒")
    @TableField("EXPENDITURE_DATE")
    private Date expenditureDate;

    @TableField("PURCHASE_ID")
    private Integer purchaseId;

    @TableField("REFUND_ID")
    private Integer refundId;

    @TableField("PAYAPPROVAL_STATE")
    private Integer payapprovalState;

    @TableField("STAFF_ID")
    public Integer staffId;

    @Excel(name = "经办人")
    @TableField("STAFF_Name")
    private String staffName;

    @TableField("DELETED")
    private Integer deleted;

    @Excel(name = "备注")
    @TableField("REMARKS")
    private String remarks;

    @Excel(name = "支出方式",replace = {"现金_0","微信_1","支付宝_2","银行卡_3"})
    @TableField("EXPENDITURE_MODE")
    private Integer expenditureMode;

    @Excel(name = "支出用途")
    @TableField("PURPOSE")
    private Integer purpose;

    @Excel(name = "提款单位/个人")
    private String drawingName;
    @TableField("DRAWING")
    private Integer drawing;



}

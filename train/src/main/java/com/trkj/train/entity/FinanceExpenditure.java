package com.trkj.train.entity;

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
 * </p >
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FINANCE_EXPENDITURE")
@ApiModel(value="FinanceExpenditure对象", description="")
@KeySequence(value = "expenditure_seq")
public class FinanceExpenditure implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "EXPENDITURE_ID",type = IdType.INPUT)
    private Integer expenditureId;

    @TableField("EXPENDITURE_MONEY")
    private Integer expenditureMoney;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("EXPENDITURE_DATE")
    private Date expenditureDate;

    @TableField("PURCHASE_ID")
    private Integer purchaseId;

    @TableField("REFUND_ID")
    private Integer refundId;

    @TableField("PAYAPPROVAL_STATE")
    private Integer payapprovalState;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;

    @TableField("REMARKS")
    private String remarks;

    @TableField("EXPENDITURE_MODE")
    private Integer expenditureMode;

    @TableField("PURPOSE")
    private String purpose;

    @TableField("DRAWING")
    private Integer drawing;

}
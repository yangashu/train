package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("FINANCE_EXPENDITURE")
@ApiModel(value="FinanceExpenditure对象", description="")
public class FinanceExpenditure implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("EXPENDITURE_ID")
    private Integer expenditureId;

    @TableField("EXPENDITURE_MONEY")
    private Integer expenditureMoney;

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


}

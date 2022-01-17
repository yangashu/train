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
@TableName("FINANCE_PAY")
@ApiModel(value="FinancePay对象", description="")
public class FinancePay implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("PAYMONEY_ID")
    private Integer paymoneyId;

    @TableField("PAYMONEY_MONEY")
    private Integer paymoneyMoney;

    @TableField("PAYMONEY_DATE")
    private Date paymoneyDate;

    @TableField("PAYMONEY_MODE")
    private String paymoneyMode;

    @TableField("COURSE_ID")
    private Integer courseId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("INCOME_STATE")
    private Integer incomeState;

    @TableField("DELETED")
    private Integer deleted;


}

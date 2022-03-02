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
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FINANCE_PURCHASE")
@ApiModel(value="FinancePurchase对象", description="")
@KeySequence(value = "purchase_seq")
public class FinancePurchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PURCHASE_ID",type = IdType.INPUT)
    private Integer purchaseId;

    @TableField("PURCHASE_NAME")
    private String purchaseName;

    @TableField("PURCHASE_REMARKS")
    private String purchaseRemarks;

    @TableField("PURCHASE_NUMBER")
    private Integer purchaseNumber;

    @TableField("PURCHASE_PRICE")
    private Integer purchasePrice;

    @TableField("PURCHASE_AOUNT")
    private Integer purchaseAount;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("COURSE_ID")
    private Integer courseId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("PURCHASE_DATE")
    private Date purchaseDate;

    @TableField("DELETED")
    private Integer deleted;


}

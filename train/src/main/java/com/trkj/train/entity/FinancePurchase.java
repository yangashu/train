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
@TableName("FINANCE_PURCHASE")
@ApiModel(value="FinancePurchase对象", description="")
public class FinancePurchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("PURCHASE_ID")
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

    @TableField("PURCHASE_DATE")
    private Date purchaseDate;

    @TableField("DELETED")
    private Integer deleted;


}

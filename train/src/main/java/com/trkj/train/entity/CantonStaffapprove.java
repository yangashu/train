package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.*;

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
@TableName("CANTON_STAFFAPPROVE")
@ApiModel(value="CantonStaffapprove对象", description="")
@KeySequence(value = "staffApprove_seq")
public class CantonStaffapprove implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "APPROVE_ID",type = IdType.INPUT)
    private Integer approveId;

    @TableField("APPROVE_TYPE")
    private Integer approveType;

    @TableField("APPROVE_REMARKS")
    private String approveRemarks;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;


}

package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("ECT_LEAVERECORD")
@ApiModel(value="EctLeaverecord对象", description="")
@KeySequence(value = "satffsign_seq")
public class EctLeaverecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("LEAVERECORD_ID")
    private Integer leaverecordId;

    @TableField("LEAVESCHOOL_ID")
    private Integer leaveschoolId;

    @TableField("REFUND_ID")
    private Integer refundId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("LEAVERECORD_DATE")
    private Date leaverecordDate;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;


}

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
@TableName("CANTON_STAFFLEAVE")
@ApiModel(value="CantonStaffleave对象", description="")
@KeySequence(value = "staffLeave_seq")
public class CantonStaffleave implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "LEAVE_ID",type = IdType.INPUT)
    private Integer leaveId;

    @TableField("LEAVE_CONTENT")
    private String leaveContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField("BEGIN_TIME")
    private Date beginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField("END_TIME")
    private Date endTime;

    @TableField("LEAVE_STATE")
    private Integer leaveState;

    @TableField("STAFF_ID1")
    private Integer staffId1;

    @TableField("STAFF_ID2")
    private Integer staffId2;

    @TableField("DELETED")
    private Integer deleted;


}

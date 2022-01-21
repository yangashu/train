package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
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
@TableName("ECT_LEAVEAPPROVAL")
@ApiModel(value="EctLeaveapproval对象", description="")
@KeySequence(value = "satffsign_seq")
public class EctLeaveapproval implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("LEAVEAPPROVAL_ID")
    private Integer leaveapprovalId;

    @TableField("LEAVEAPPROVAL_DATE")
    private Date leaveapprovalDate;

    @TableField("STUDENTLEAVE_ID")
    private Integer studentleaveId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;


}

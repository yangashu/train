package com.trkj.train.entity;

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
@TableName("ECT_REFUND")
@ApiModel(value="EctRefund对象", description="")
@KeySequence(value = "refund_seq")
public class EctRefund implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "REFUND_ID",type = IdType.INPUT)
    private Integer refundId;

    @TableField("REFUND_DATE")
    private Date refundDate;

    @TableField("REFUND_MONEY")
    private Integer refundMoney;

    @TableField("REFUND_STATE")
    private Integer refundState;

    @TableField("LEAVESCHOOL_ID")
    private Integer leaveschoolId;

    @TableField("CLASSRECORD_ID")
    private Integer classrecordId;

    @TableField("COURSE_ID")
    private Integer courseId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;


}

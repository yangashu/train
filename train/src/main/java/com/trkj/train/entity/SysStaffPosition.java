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
@TableName("SYS_STAFF_POSITION")
@ApiModel(value="SysStaffPosition对象", description="")
@KeySequence(value = "staff_position_seq")
public class SysStaffPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STAFFPOSITION_ID",type = IdType.INPUT)
    private Integer staffpositionId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("POSITION_ID")
    private Integer positionId;

    @TableField("DELETED")
    private Integer deleted;


}

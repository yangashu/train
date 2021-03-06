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
@TableName("CANTON_STAFFBUSINESS")
@ApiModel(value="CantonStaffbusiness对象", description="")
@KeySequence(value = "staffBusiness_seq")
public class CantonStaffbusiness implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STAFFBUSINESS_ID",type = IdType.INPUT)
    private Integer staffbusinessId;

    @TableField("STAFFBUSINESS_CONTENT")
    private String staffbusinessContent;

    @TableField("BEGIN_TIME")
    private Date beginTime;

    @TableField("END_TIME")
    private Date endTime;

    @TableField("STAFFBUSINESS_STATE")
    private Integer staffbusinessState;

    @TableField("STAFF_ID1")
    private Integer staffId1;

    @TableField("STAFF_ID2")
    private Integer staffId2;

    @TableField("DELETED")
    private Integer deleted;


}

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
@TableName("SYS_POSITION")
@ApiModel(value="SysPosition对象", description="")
public class SysPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("POSITION_ID")
    private Integer positionId;

    @TableField("POSITION_NAME")
    private String positionName;

    @TableField("POSITION_CODE")
    private String positionCode;

    @TableField("POSITION_REMARK")
    private String positionRemark;

    @TableField("POSITION_CREATED")
    private Date positionCreated;

    @TableField("POSITION_UPDATED")
    private Date positionUpdated;

    @TableField("POSITION_STATE")
    private Integer positionState;

    @TableField("DEPT_ID")
    private Integer deptId;

    @TableField("DELETED")
    private Integer deleted;


}

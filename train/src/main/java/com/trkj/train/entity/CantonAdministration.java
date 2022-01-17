package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("CANTON_ADMINISTRATION")
@ApiModel(value="CantonAdministration对象", description="")
public class CantonAdministration implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ADMINISTRATION_ID")
    private Integer administrationId;

    @TableField("ADMINISTRATION_STATE")
    private Integer administrationState;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DEPT_ID")
    private Integer deptId;

    @TableField("POSITION_ID")
    private Integer positionId;

    @TableField("DELETED")
    private Integer deleted;


}

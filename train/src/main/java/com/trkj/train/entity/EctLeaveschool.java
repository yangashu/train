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
@TableName("ECT_LEAVESCHOOL")
@ApiModel(value="EctLeaveschool对象", description="")
public class EctLeaveschool implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("LEAVESCHOOL_ID")
    private Integer leaveschoolId;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("LEAVESCHOOL_DATE")
    private Date leaveschoolDate;

    @TableField("LEAVESCHOOL_REASON")
    private String leaveschoolReason;

    @TableField("DELETED")
    private Integer deleted;


}

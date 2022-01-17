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
@TableName("CANTON_INTERVIEW")
@ApiModel(value="CantonInterview对象", description="")
public class CantonInterview implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("INTERVIEW_ID")
    private Integer interviewId;

    @TableField("INTERVIEW_CENTENT")
    private String interviewCentent;

    @TableField("INTERVIEW_STATE")
    private Integer interviewState;

    @TableField("PERSONAL_ID")
    private Integer personalId;

    @TableField("DELETED")
    private Integer deleted;


}

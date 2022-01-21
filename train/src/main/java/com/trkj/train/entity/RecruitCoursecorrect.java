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
@TableName("RECRUIT_COURSECORRECT")
@ApiModel(value="RecruitCoursecorrect对象", description="")
@KeySequence(value = "courseCorrect_seq")
public class RecruitCoursecorrect implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "COURSECORRECT_ID",type = IdType.INPUT)
    private Integer coursecorrectId;

    @TableField("COURSECORRECT_REMARKS")
    private String coursecorrectRemarks;

    @TableField("COURSECORRECT_DATE")
    private Date coursecorrectDate;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;


}

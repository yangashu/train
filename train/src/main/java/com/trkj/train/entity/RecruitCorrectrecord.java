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
@TableName("RECRUIT_CORRECTRECORD")
@ApiModel(value="RecruitCorrectrecord对象", description="")
@KeySequence(value = "correctRecord_seq")
public class RecruitCorrectrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CORRECTRECORD_ID",type = IdType.INPUT)
    private Integer correctrecordId;

    @TableField("CORRECTRECORD_DATE")
    private Date correctrecordDate;

    @TableField("COURSE_ID")
    private Integer courseId;

    @TableField("COURSECORRECT_ID")
    private Integer coursecorrectId;

    @TableField("DELETED")
    private Integer deleted;


}

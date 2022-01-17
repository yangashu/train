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
@TableName("RECRUIT_CORRECTRECORD")
@ApiModel(value="RecruitCorrectrecord对象", description="")
public class RecruitCorrectrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("CORRECTRECORD_ID")
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

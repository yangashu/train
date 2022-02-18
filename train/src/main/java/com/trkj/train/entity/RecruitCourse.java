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
@TableName("RECRUIT_COURSE")
@ApiModel(value="RecruitCourse对象", description="")
@KeySequence(value = "course_seq")
public class RecruitCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "COURSE_ID",type = IdType.INPUT)
    private Integer courseId;

    @TableField("COURSE_NAME")
    private String courseName;

    @TableField("COURSE_MONEY")
    private Integer courseMoney;

    @TableField("COURSE_HOUR")
    private Integer courseHour;

    @TableField("COURSE_PRICE")
    private Integer coursePrice;

    @TableField("BOOK_FEE")
    private Integer bookFee;

    @TableLogic
    @TableField("DELETED")
    private Integer deleted;


}

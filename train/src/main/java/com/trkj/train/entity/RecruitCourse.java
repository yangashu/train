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
@TableName("RECRUIT_COURSE")
@ApiModel(value="RecruitCourse对象", description="")
public class RecruitCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("COURSE_ID")
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

    @TableField("DELETED")
    private Integer deleted;


}

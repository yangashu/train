package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("ECT_CLASSES")
@ApiModel(value="EctClasses对象", description="")
@KeySequence(value = "satffsign_seq")
public class EctClasses implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CLASSES_ID",type = IdType.INPUT)
    private Integer classesId;

    @TableField("CLASSES_NAME")
    private String classesName;

    @TableField("CLASSES_NUMBER")
    private Integer classesNumber;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("CLASSES_DATE")
    private Date classesDate;

    @TableField("CLASSES_HOUR")
    private Integer classesHour;

    @TableField("COURSE_ID")
    private Integer courseId;

    @TableField("CLASSROOM_ID")
    private Integer classroomId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField(exist = false)
    private String oldClassName="false";

    @TableLogic
    @TableField("DELETED")
    private Integer deleted;


}

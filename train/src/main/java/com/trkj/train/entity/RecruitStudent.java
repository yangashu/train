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
@TableName("RECRUIT_STUDENT")
@ApiModel(value="RecruitStudent对象", description="")
@KeySequence(value = "student_seq")
public class RecruitStudent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STUDENT_ID",type = IdType.INPUT)
    private Integer studentId;

    @TableField("STUDENT_NAME")
    private String studentName;

    @TableField("STUDENT_SEX")
    private String studentSex;

    @TableField("STUDENT_AGE")
    private Integer studentAge;

    @TableField("STUDENT_BIRTHDAY")
    private Date studentBirthday;

    @TableField("STUDENT_PHONE")
    private String studentPhone;

    @TableField("PARENT_PHONE")
    private String parentPhone;

    @TableField("STUDENT_SCHOOL")
    private String studentSchool;

    @TableField("STUDENT_LOC")
    private String studentLoc;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("STUDENT_ENTRANCE")
    private Date studentEntrance;

    @TableField("CLASSES_ID")
    private Integer classesId;

    @TableField("COURSE_ID")
    private Integer courseId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableLogic
    @TableField("DELETED")
    private Integer deleted;


}

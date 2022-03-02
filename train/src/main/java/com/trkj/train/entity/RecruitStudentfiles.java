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
@TableName("RECRUIT_STUDENTFILES")
@ApiModel(value="RecruitStudentfiles对象", description="")
@KeySequence(value = "studentFiles_seq")
public class RecruitStudentfiles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STUDENTFILES_ID",type = IdType.INPUT)
    private Integer studentfilesId;

    @TableField("STUDENTFILES_NAME")
    private String studentfilesName;

    @TableField("STUDENTFILES_SEX")
    private String studentfilesSex;

    @TableField("STUDENTFILES_AGE")
    private Integer studentfilesAge;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("STUDENTFILES_BIRTHDAY")
    private Date studentfilesBirthday;

    @TableField("STUDENTFILES_PHONE")
    private String studentfilesPhone;

    @TableField("PARENT_PHONE")
    private String parentPhone;

    @TableField("STUDENTFILES_SCHOOL")
    private String studentfilesSchool;

    @TableField("STUDENTFILES_LOC")
    private String studentfilesLoc;

    @TableField("STUDENTFILES_REMARKS")
    private String studentfilesRemarks;

    @JsonFormat(pattern = "YYYY-MM-DD",timezone = "GMT+8")
    @TableField("STUDENTFILES_TIME")
    private Date studentfilesTime;

    @TableField("CHANNEL_ID")
    private Integer channelId;

    @TableField("STUDENTFILES_STATE")
    private Integer studentfilesState;

    @TableField("COURSE_ID")
    private Integer courseId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableLogic
    @TableField("DELETED")
    private Integer deleted;


}

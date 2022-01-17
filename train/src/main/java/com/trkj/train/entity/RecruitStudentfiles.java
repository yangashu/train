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
@TableName("RECRUIT_STUDENTFILES")
@ApiModel(value="RecruitStudentfiles对象", description="")
public class RecruitStudentfiles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("STUDENTFILES_ID")
    private Integer studentfilesId;

    @TableField("STUDENTFILES_NAME")
    private String studentfilesName;

    @TableField("STUDENTFILES_SEX")
    private String studentfilesSex;

    @TableField("STUDENTFILES_AGE")
    private Integer studentfilesAge;

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

    @TableField("CHANNEL_ID")
    private Integer channelId;

    @TableField("STUDENTFILES_STATE")
    private Integer studentfilesState;

    @TableField("COURSE_ID")
    private Integer courseId;

    @TableField("DELETED")
    private Integer deleted;


}

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
@TableName("RECRUIT_STUDENTTALK")
@ApiModel(value="RecruitStudenttalk对象", description="")
@KeySequence(value = "studentTalk_seq")
public class RecruitStudenttalk implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STUDENTTALK_ID",type = IdType.INPUT)
    private Integer studenttalkId;

    @TableField("STUDENTTALK_CONTENT")
    private String studenttalkContent;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("STUDENTTALK_DATE")
    private Date studenttalkDate;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("DELETED")
    private Integer deleted;


}

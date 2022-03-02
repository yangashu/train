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
@TableName("RECRUIT_STUNDENTPUNISH")
@ApiModel(value="RecruitStundentpunish对象", description="")
@KeySequence(value = "stundentPunish_seq")
public class RecruitStundentpunish implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STUNDENTPUNISH_ID",type = IdType.INPUT)
    private Integer stundentpunishId;

    @TableField("STUNDENTPUNISH_GRADE")
    private Integer stundentpunishGrade;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("STUNDENTPUNISH_DATE")
    private Date stundentpunishDate;

    @TableField("STUNDENTPUNISH_REASON")
    private String stundentpunishReason;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("DELETED")
    private Integer deleted;


}

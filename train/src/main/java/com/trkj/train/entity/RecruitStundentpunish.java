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
@TableName("RECRUIT_STUNDENTPUNISH")
@ApiModel(value="RecruitStundentpunish对象", description="")
public class RecruitStundentpunish implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("STUNDENTPUNISH_ID")
    private Integer stundentpunishId;

    @TableField("STUNDENTPUNISH_GRADE")
    private Integer stundentpunishGrade;

    @TableField("STUNDENTPUNISH_DATE")
    private Date stundentpunishDate;

    @TableField("STUNDENTPUNISH_REASON")
    private String stundentpunishReason;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("DELETED")
    private Integer deleted;


}

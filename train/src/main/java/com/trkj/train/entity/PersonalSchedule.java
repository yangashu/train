package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
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
@TableName("PERSONAL_SCHEDULE")
@ApiModel(value="PersonalSchedule对象", description="")
@KeySequence(value = "suggestions_seq")
public class PersonalSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("SCHEDULE_ID")
    private Integer scheduleId;

    @TableField("SCHEDULE_THEME")
    private String scheduleTheme;

    @TableField("SCHEDULE_TYPE")
    private Integer scheduleType;

    @TableField("BEGIN_TIME")
    private Date beginTime;

    @TableField("END_TIME")
    private Date endTime;

    @TableField("SCHEDULE_PLACE")
    private String schedulePlace;

    @TableField("SCHEDULE_CONTENT")
    private String scheduleContent;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;


}

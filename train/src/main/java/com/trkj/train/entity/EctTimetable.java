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
@TableName("ECT_TIMETABLE")
@ApiModel(value="EctTimetable对象", description="")
@KeySequence(value = "timetable_seq")
public class EctTimetable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TIMETABLE_ID",type = IdType.INPUT)
    private Integer timetableId;

    @TableField("TIMETABLE_MORNING")
    private String timetableMorning;

    @TableField("TIMETABLE_AFTERNOON")
    private String timetableAfternoon;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField("TIMETABLE_TIME")
    private Date timetableTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField("TIMETABLE_MORNINGEND")
    private Date timetableMorningend;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField("TIMETABLE_AFTERNOONSTART")
    private Date timetableAfternoonstart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField("TIMETABLE_AFTERNOONEND")
    private Date timetableAfternoonend;

    @TableField("TIMETABLE_DATE")
    private Date timetableDate;

    @TableField("TIMETABLE_STATE")
    private Integer timetableState;

    @TableField("CLASSES_ID")
    private Integer classesId;

    @TableField("TEACHING_ID")
    private Integer teachingId;

    @TableField("STAFF_ID1")
    private Integer staffId1;

    @TableField("STAFF_ID2")
    private Integer staffId2;

    @TableLogic
    @TableField("DELETED")
    private Integer deleted;


}

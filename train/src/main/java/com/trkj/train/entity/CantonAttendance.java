package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
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
@TableName("CANTON_ATTENDANCE")
@ApiModel(value="CantonAttendance对象", description="")
@KeySequence(value = "Attendance_seq")
public class CantonAttendance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ATTENDANCE_ID",type = IdType.INPUT)
    private Integer attendanceId;

    @TableField("ATTENDANCE_DATE")
    private Date attendanceDate;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;


}

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
@TableName("ECT_STUDENTLEAVE")
@ApiModel(value="EctStudentleave对象", description="")
@KeySequence(value = "studentLeave_seq")
public class EctStudentleave implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STUDENTLEAVE_ID",type = IdType.INPUT)
    private Integer studentleaveId;

    @TableField("STUDENTLEAVE_STARTIME")
    private Date studentleaveStartime;

    @TableField("STUDENTLEAVE_ENDTIME")
    private Date studentleaveEndtime;

    @TableField("STUDENTLEAVE_REASON")
    private String studentleaveReason;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("DELETED")
    private Integer deleted;


}

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
@TableName("ECT_STUDENTATTEND")
@ApiModel(value="EctStudentattend对象", description="")
@KeySequence(value = "studentAttend_seq")
public class EctStudentattend implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STUDENTATTEND_ID",type = IdType.INPUT)
    private Integer studentattendId;

    @TableField("STUDENTATTEND_TYPE")
    private Integer studentattendType;

    @TableField("STUDENTATTEND_DATE")
    private Date studentattendDate;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("DELETED")
    private Integer deleted;


}

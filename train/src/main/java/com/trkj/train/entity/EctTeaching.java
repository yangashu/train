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
@TableName("ECT_TEACHING")
@ApiModel(value="EctTeaching对象", description="")
@KeySequence(value = "teaching_seq")
public class EctTeaching implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TEACHING_ID",type = IdType.INPUT)
    private Integer teachingId;

    @TableField("BEGIN_DATE")
    private Date beginDate;

    @TableField("END_TIME")
    private Date endTime;

    @TableField("CLASSES_STATE")
    private Integer classesState;

    @TableField("CLASSES_ID")
    private Integer classesId;

    @TableField("DELETED")
    private Integer deleted;


}

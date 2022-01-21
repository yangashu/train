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
@TableName("ECT_TEACHRECORD")
@ApiModel(value="EctTeachrecord对象", description="")
@KeySequence(value = "teachrecord_seq")
public class EctTeachrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TEACHRECORD_ID",type = IdType.INPUT)
    private Integer teachrecordId;

    @TableField("TEACHRECORD_DATE")
    private Date teachrecordDate;

    @TableField("TEACHING_ID")
    private Integer teachingId;

    @TableField("DELETED")
    private Integer deleted;


}

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
@TableName("ECT_TRANSFERRECORD")
@ApiModel(value="EctTransferrecord对象", description="")
@KeySequence(value = "transferRecord_seq")
public class EctTransferrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TRANSFERRECORD_ID",type = IdType.INPUT)
    private Integer transferrecordId;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("TRANSFERRECORD_STATE")
    private Integer transferrecordState;

    @TableField("CLASSES_ONE")
    private Integer classesOne;

    @TableField("CLASSES_TWO")
    private Integer classesTwo;

    @JsonFormat(pattern = "YYYY-MM-DD",timezone = "GMT+8")
    @TableField("TRANSFERRECORD_DATE")
    private Date transferrecordDate;

    @TableField("TRANSFERRECORD_REASON")
    private String transferrecordReason;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;


}

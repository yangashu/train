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
@TableName("ECT_OUTWAREHOUSE")
@ApiModel(value="EctOutwarehouse对象", description="")
@KeySequence(value = "outWarehouse_seq")
public class EctOutwarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "OUTWAREHOUSE_ID",type = IdType.INPUT)
    private Integer outwarehouseId;

    @TableField("OUTWAREHOUSE_NUMBER")
    private Integer outwarehouseNumber;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("OUTWAREHOUSE_TIME")
    private Date outwarehouseTime;

    @TableField("CLASSES_ID")
    private Integer classesId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("STAFF_ID2")
    private Integer staffId2;

    @TableField("WAREHOUSE_ID")
    private Integer warehouseId;

    @TableField("DELETED")
    private Integer deleted;


}

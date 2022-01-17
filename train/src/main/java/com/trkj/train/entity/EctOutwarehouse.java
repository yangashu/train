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
@TableName("ECT_OUTWAREHOUSE")
@ApiModel(value="EctOutwarehouse对象", description="")
public class EctOutwarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("OUTWAREHOUSE_ID")
    private Integer outwarehouseId;

    @TableField("OUTWAREHOUSE_NUMBER")
    private Integer outwarehouseNumber;

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

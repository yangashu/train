package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("ECT_WAREHOUSE")
@ApiModel(value="EctWarehouse对象", description="")
public class EctWarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("WAREHOUSE_ID")
    private Integer warehouseId;

    @TableField("WAREHOUSE_NAME")
    private String warehouseName;

    @TableField("WAREHOUSE_NUMBER")
    private Integer warehouseNumber;

    @TableField("WAREHOUSE_PRICE")
    private Integer warehousePrice;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;


}

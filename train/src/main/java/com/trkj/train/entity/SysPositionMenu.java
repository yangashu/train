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
@TableName("SYS_POSITION_MENU")
@ApiModel(value="SysPositionMenu对象", description="")
public class SysPositionMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("POSITIONMENU_ID")
    private Integer positionmenuId;

    @TableField("MENU_ID")
    private Integer menuId;

    @TableField("POSITION_ID")
    private Integer positionId;

    @TableField("DELETED")
    private Integer deleted;


}

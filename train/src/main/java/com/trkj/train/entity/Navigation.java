package com.trkj.train.entity;

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
@ApiModel(value="Navigation对象", description="")
public class Navigation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("NAVIGATION_ID")
    private Integer navigationId;

    @TableField("NAVIGATION_NAME")
    private String navigationName;

    @TableField("NAVIGATION_PID")
    private Integer navigationPid;

    @TableField("NAVIGATION_URL")
    private String navigationUrl;

    @TableField("NAVIGATION_ICON")
    private String navigationIcon;

    @TableField("DELETED")
    private Integer deleted;


}

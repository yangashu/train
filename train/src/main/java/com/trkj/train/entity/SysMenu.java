package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

import io.lettuce.core.dynamic.annotation.Key;
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
@TableName("SYS_MENU")
@ApiModel(value="SysMenu对象", description="")
@KeySequence(value = "menu_seq")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "MENU_ID",type = IdType.INPUT)
    private Integer menuId;

    @TableField("MENU_PID")
    private Integer menuPid;

    @TableField("MENU_NAME")
    private String menuName;

    @TableField("MENU_URL")
    private String menuUrl;

    @TableField("MENU_PERMS")
    private String menuPerms;

    @TableField("MENU_COMPONENT")
    private String menuComponent;

    @TableField("MENU_TYPE")
    private Integer menuType;

    @TableField("MENU_ICON")
    private String menuIcon;

    @TableField("MENU_ORDERNUM")
    private Integer menuOrdernum;

    @TableField("MENU_CREATED")
    private Date menuCreated;

    @TableField("MENU_UPDATED")
    private Date menuUpdated;

    @TableField("MENU_STATE")
    private Integer menuState;

    @TableField("MENU_DESCRIBE")
    private String menuDescribe;

    @TableField("DELETED")
    private Integer deleted;

    @TableField(exist = false)
    private List<SysMenu> children=new ArrayList<>();


}

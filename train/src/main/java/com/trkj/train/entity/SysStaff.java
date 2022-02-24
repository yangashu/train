package com.trkj.train.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

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
 * @since 2022-01-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_STAFF")
@ApiModel(value="SysStaff对象", description="")
@KeySequence(value = "staff_seq")
@ExcelTarget("SysStaff")
public class SysStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STAFF_ID",type = IdType.INPUT)
    private Integer staffId;

    @Excel(name = "录入人")
    @TableField("STAFF_NAME")
    private String staffName;

    @TableField("STAFF_PASS")
    private String staffPass;

    @TableField("STAFF_STATE")
    private Integer staffState;

    @TableField("STAFF_TIME")
    private Date staffTime;

    @TableField("PERSONAL_ID")
    private Integer personalId;

    @TableField(exist = false)
    private String token;

    @TableField(exist = false)
    private SysPersonal personal;

    @TableField(exist = false)
    private List<SysPosition> positions=new ArrayList<>();

    @TableField(exist = false)
    private List<SysStaffPosition> staffPositions=new ArrayList<>();

    @TableField("DELETED")
    private Integer deleted;


}

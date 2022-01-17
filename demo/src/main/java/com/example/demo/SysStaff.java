package com.example.demo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class SysStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("STAFF_ID")
    private Integer staffId;

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

//    @TableField(exist = false)
//    private SysPersonal personal;
//
//    @TableField(exist = false)
//    private List<SysPosition> positions=new ArrayList<>();
//
//    @TableField(exist = false)
//    private List<SysStaffPosition> staffPositions=new ArrayList<>();

    @TableField("DELETED")
    private Integer deleted;


}

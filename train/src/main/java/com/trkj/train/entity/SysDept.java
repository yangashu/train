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
@TableName("SYS_DEPT")
@ApiModel(value="SysDept对象", description="")
@KeySequence(value = "dept_seq")
public class SysDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DEPT_ID",type = IdType.INPUT)
    private Integer deptId;

    @TableField("DEPT_NAME")
    private String deptName;

    @TableField("DEPT_TIME")
    private Date deptTime;

    @TableField("DELETED")
    private Integer deleted;


}

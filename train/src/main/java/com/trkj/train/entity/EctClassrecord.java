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
@TableName("ECT_CLASSRECORD")
@ApiModel(value="EctClassrecord对象", description="")
public class EctClassrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("CLASSRECORD_ID")
    private Integer classrecordId;

    @TableField("CLASSES_ID")
    private Integer classesId;

    @TableField("COURSE_ID")
    private Integer courseId;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("STUDENTATTEND_ID")
    private Integer studentattendId;

    @TableField("DELETED")
    private Integer deleted;


}

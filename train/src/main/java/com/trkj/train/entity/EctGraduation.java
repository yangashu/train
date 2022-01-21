package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
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
@TableName("ECT_GRADUATION")
@ApiModel(value="EctGraduation对象", description="")
@KeySequence(value = "satffsign_seq")
public class EctGraduation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("GRADUATION_ID")
    private Integer graduationId;

    @TableField("GRADUATION_DATE")
    private Date graduationDate;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("COURSE_ID")
    private Integer courseId;

    @TableField("DELETED")
    private Integer deleted;


}

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
@TableName("RECRUIT_STUDENTHONOR")
@ApiModel(value="RecruitStudenthonor对象", description="")
@KeySequence(value = "studentHonor_seq")
public class RecruitStudenthonor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "STUDENTHONOR_ID",type = IdType.INPUT)
    private Integer studenthonorId;

    @TableField("STUDENTHONOR_DATE")
    private Date studenthonorDate;

    @TableField("STUDENTHONOR_CONTENT")
    private String studenthonorContent;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("DELETED")
    private Integer deleted;


}

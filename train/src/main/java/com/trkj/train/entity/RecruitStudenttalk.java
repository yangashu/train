package com.trkj.train.entity;

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
@TableName("RECRUIT_STUDENTTALK")
@ApiModel(value="RecruitStudenttalk对象", description="")
public class RecruitStudenttalk implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("STUDENTTALK_ID")
    private Integer studenttalkId;

    @TableField("STUDENTTALK_CONTENT")
    private String studenttalkContent;

    @TableField("STUDENTTALK_DATE")
    private Date studenttalkDate;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("STUDENT_ID")
    private Integer studentId;

    @TableField("DELETED")
    private Integer deleted;


}

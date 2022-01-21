package com.trkj.train.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
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
@TableName("ECT_CLASSROOM")
@ApiModel(value="EctClassroom对象", description="")
@KeySequence(value = "satffsign_seq")
public class EctClassroom implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("CLASSROOM_ID")
    private Integer classroomId;

    @TableField("CLASSROOM_NAME")
    private String classroomName;

    @TableField("CALSSROOM_STATE")
    private Integer calssroomState;

    @TableField("DELETED")
    private Integer deleted;


}

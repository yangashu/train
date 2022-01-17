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
@TableName("RECRUIT_CHANNEL")
@ApiModel(value="RecruitChannel对象", description="")
public class RecruitChannel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("CHANNEL_ID")
    private Integer channelId;

    @TableField("CHANNEL_NAME")
    private String channelName;

    @TableField("CHANNEL_LOC")
    private String channelLoc;

    @TableField("DELETED")
    private Integer deleted;


}

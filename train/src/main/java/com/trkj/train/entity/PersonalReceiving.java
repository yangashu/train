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
@TableName("PERSONAL_RECEIVING")
@ApiModel(value="PersonalReceiving对象", description="")
@KeySequence(value = "suggestions_seq")
public class PersonalReceiving implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("RECEIVING_ID")
    private Integer receivingId;

    @TableField("RECEIVING_TITLE")
    private String receivingTitle;

    @TableField("RECEIVING_CONTENT")
    private String receivingContent;

    @TableField("RECEIVING_DATE")
    private Date receivingDate;

    @TableField("RECEIVING_STATE")
    private Integer receivingState;

    @TableField("STAFF_ID1")
    private Integer staffId1;

    @TableField("STAFF_ID2")
    private Integer staffId2;

    @TableField("DELETED")
    private Integer deleted;


}

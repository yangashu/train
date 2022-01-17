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
@TableName("PERSONAL_DRAFT")
@ApiModel(value="PersonalDraft对象", description="")
public class PersonalDraft implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("DRAFT_ID")
    private Integer draftId;

    @TableField("DRAFT_TITLE")
    private String draftTitle;

    @TableField("DRAFT_CONTENT")
    private String draftContent;

    @TableField("DRAFT_DATE")
    private Date draftDate;

    @TableField("STAFF_ID1")
    private Integer staffId1;

    @TableField("STAFF_ID2")
    private Integer staffId2;

    @TableField("DELETED")
    private Integer deleted;


}

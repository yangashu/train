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
@TableName("PERSONAL_NOTEPAD")
@ApiModel(value="PersonalNotepad对象", description="")
public class PersonalNotepad implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("NOTEPAD_ID")
    private Integer notepadId;

    @TableField("NOTEPAD_THEME")
    private String notepadTheme;

    @TableField("NOTEPAD_TYPE")
    private Integer notepadType;

    @TableField("BEGIN_TIME")
    private Date beginTime;

    @TableField("END_TIME")
    private Date endTime;

    @TableField("NOTEPAD_PLACE")
    private String notepadPlace;

    @TableField("NOTEPAD_CONTENT")
    private String notepadContent;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;


}

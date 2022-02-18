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
@TableName("NEWS_SUGGESTIONS")
@ApiModel(value="NewsSuggestions对象", description="")
@KeySequence(value = "suggestions_seq")
public class NewsSuggestions implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "SUGGESTIONS_ID",type = IdType.INPUT)
    private Integer suggestionsId;

    @TableField("SUGGESTIONS_CONTENT")
    private String suggestionsContent;

    @TableField("SUGGESTIONS_DATE")
    private Date suggestionsDate;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private int deleted;


}

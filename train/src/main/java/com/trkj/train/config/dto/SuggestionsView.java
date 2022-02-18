package com.trkj.train.config.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuggestionsView {

    @TableField("STAFF_NAME")
    private String staffName;

    @TableId(value = "SUGGESTIONS_ID",type = IdType.INPUT)
    private Integer suggestionsId;

    @TableField("SUGGESTIONS_CONTENT")
    private String suggestionsContent;

    @TableField("SUGGESTIONS_DATE")
    private Date suggestionsDate;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;
}

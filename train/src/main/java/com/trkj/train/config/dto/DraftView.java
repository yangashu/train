package com.trkj.train.config.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DraftView {

    @TableField("STAFF_NAME")
    private String staffName;

    @TableId(value = "DRAFT_ID",type = IdType.INPUT)
    private int draftId;

    @TableField("DRAFT_TITLE")
    private String draftTitle;

    @TableField("DRAFT_CONTENT")
    private String draftContent;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("DRAFT_DATE")
    private Date draftDate;

    @TableField("STAFF_ID1")
    private int staffId1;

    @TableField("STAFF_ID2")
    private int staffId2;

    @TableLogic
    @TableField("DELETED")
    private int deleted;
}

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
public class ReceivingView {
    @TableField("STAFF_NAME")
    private String staffName;

    @TableId(value = "RECEIVING_ID",type = IdType.INPUT)
    private int receivingId;

    @TableField("RECEIVING_TITLE")
    private String receivingTitle;

    @TableField("RECEIVING_CONTENT")
    private String receivingContent;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("RECEIVING_DATE")
    private Date receivingDate;

    @TableField("RECEIVING_STATE")
    private int receivingState;

    @TableField("STAFF_ID1")
    private int staffId1;

    @TableField("STAFF_ID2")
    private int staffId2;

    @TableLogic
    @TableField("DELETED")
    private int deleted;
}

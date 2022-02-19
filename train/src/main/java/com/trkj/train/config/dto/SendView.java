package com.trkj.train.config.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendView {

    @TableField("STAFF_NAME")
    private String staffName;

    @TableId("SEND_ID")
    private int sendId;

    @TableField("SEND_TITLE")
    private String sendTitle;

    @TableField("SEND_CONTENT")
    private String sendContent;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @TableField("SEND_DATE")
    private Date sendDate;

    @TableField("STAFF_ID1")
    private int staffId1;

    @TableField("STAFF_ID2")
    private int staffId2;

    @TableField("DELETED")
    private int deleted;
}

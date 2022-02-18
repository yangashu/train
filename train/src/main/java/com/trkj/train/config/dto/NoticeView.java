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
public class NoticeView {

    @TableField("STAFF_NAME")
    private String staffName;

    @TableId(value = "NOTICE_ID",type = IdType.INPUT)
    private Integer noticeId;

    @TableField("NOTICE_TYPE")
    private Integer noticeType;

    @TableField("NOTICE_THEME")
    private String noticeTheme;

    @TableField("NOTICE_CONTENT")
    private String noticeContent;

    @TableField("NOTICE_DATE")
    private Date noticeDate;

    @TableField("STAFF_ID")
    private Integer staffId;

    @TableField("DELETED")
    private Integer deleted;

    @TableField("STATE")
    private Integer state;
}

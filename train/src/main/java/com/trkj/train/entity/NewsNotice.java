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
@TableName("NEWS_NOTICE")
@ApiModel(value="NewsNotice对象", description="")
@KeySequence(value = "notice_seq")
public class NewsNotice implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @TableField("DEPT_ID")
    private Integer deptId;

}

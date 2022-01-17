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
@TableName("SYS_PERSONAL")
@ApiModel(value="SysPersonal对象", description="")
public class SysPersonal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("PERSONAL_ID")
    private Integer personalId;

    @TableField("PERSONAL_AVATAR")
    private String personalAvatar;

    @TableField("PERSONAL_NAME")
    private String personalName;

    @TableField("PERSONAL_SEX")
    private String personalSex;

    @TableField("PERSONAL_AGE")
    private Integer personalAge;

    @TableField("PERSONAL_BIRTHDAY")
    private Date personalBirthday;

    @TableField("PERSONAL_IDCARD")
    private String personalIdcard;

    @TableField("PERSONAL_PHONE")
    private String personalPhone;

    @TableField("PERSONAL_MAIL")
    private String personalMail;

    @TableField("PERSONAL_EDUCATION")
    private String personalEducation;

    @TableField("PERSONAL_NFAMILY")
    private String personalNfamily;

    @TableField("PERSONAL_ADDRESS")
    private String personalAddress;

    @TableField("PERSONAL_GRADUATION")
    private String personalGraduation;

    @TableField("PERSONAL_EXPERIENCE")
    private String personalExperience;

    @TableField("PERSONAL_MONNEY")
    private Integer personalMonney;

    @TableField("PERSONAL_POSITION")
    private String personalPosition;

    @TableField("PERSONAL_INTERVIEW")
    private Date personalInterview;

    @TableField("ENTRY_TIME")
    private Date entryTime;

    @TableField("PERSONAL_TYPE")
    private Integer personalType;

    @TableField("DELETED")
    private Integer deleted;


}

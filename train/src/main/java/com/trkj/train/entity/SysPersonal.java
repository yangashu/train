package com.trkj.train.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@KeySequence(value = "personal_seq")
@ExcelTarget("员工档案")
public class SysPersonal implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PERSONAL_ID",type = IdType.INPUT)
    private Integer personalId;

    @TableField("PERSONAL_AVATAR")
    private String personalAvatar;

    @Excel(name = "姓名")
    @TableField("PERSONAL_NAME")
    private String personalName;

    @Excel(name = "性别")
    @TableField("PERSONAL_SEX")
    private String personalSex;

    @Excel(name = "年龄")
    @TableField("PERSONAL_AGE")
    private Integer personalAge;

    @Excel(name = "生日",format = "yyyy年MM月dd日 00时00分00秒")
    @TableField("PERSONAL_BIRTHDAY")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date personalBirthday;

    @Excel(name = "身份证号")
    @TableField("PERSONAL_IDCARD")
    private String personalIdcard;

    @Excel(name = "联系电话")
    @TableField("PERSONAL_PHONE")
    private String personalPhone;

    @Excel(name = "邮箱")
    @TableField("PERSONAL_MAIL")
    private String personalMail;

    @Excel(name = "学历")
    @TableField("PERSONAL_EDUCATION")
    private String personalEducation;

    @Excel(name = "民族")
    @TableField("PERSONAL_NFAMILY")
    private String personalNfamily;

    @Excel(name = "住址")
    @TableField("PERSONAL_ADDRESS")
    private String personalAddress;

    @Excel(name = "毕业学校")
    @TableField("PERSONAL_GRADUATION")
    private String personalGraduation;

    @Excel(name = "工作经历")
    @TableField("PERSONAL_EXPERIENCE")
    private String personalExperience;

    @Excel(name = "期望薪资")
    @TableField("PERSONAL_MONNEY")
    private Integer personalMonney;

    @Excel(name = "面试岗位")
    @TableField("PERSONAL_POSITION")
    private String personalPosition;

//    @Excel(name = "面试时间",format = "yyyy年MM月dd日 HH时mm分ss秒")
    @TableField("PERSONAL_INTERVIEW")
    private Date personalInterview=new Date();

//    @Excel(name = "入职时间")
    @TableField("ENTRY_TIME")
    private Date entryTime=new Date();

    @Excel(name = "当前状态",replace = {"已入职_0","未入职_1"})
    @TableField("PERSONAL_TYPE")
    private Integer personalType;

    @TableField("DELETED")
    private Integer deleted;


}

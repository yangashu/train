package com.trkj.train.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class staffAndPersonal {
    private int staffId; //员工ID
    private String staffName; //登录的用户名
    private String staffPass; //登录的用户密码
    private int staffState; //员工状态
    private int personalId; //员工资料ID
    private String personalAvatar;//员工头像
    private String personalName; //员工姓名
    private String personalSex; //员工性别
    private int personalAge; //员工年龄
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date personalBirthday;//员工生日
    private String personalIdcard;//员工身份证
    private String personalPhone;//员工联系电话
    private String personalMail;//员工邮箱
    private String personalEducation;//员工学历
    private String personalNfamily;//员工民族
    private String personalGraduation;//毕业学校
    private String personalExperience;//工作经历
    private String personalAddress;//现居住地址
    private String personalPosition;//面试岗位
    private Date personalInterview;//面试时间
    private Date entryTime;//入职时间
}

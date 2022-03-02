package com.trkj.train.TyVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ty
 * @date 2022/1/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentfilesQudaoDo {
//    渠道管理的 查看学员弹框Do
    private int studentfilesId;
    private String studentfilesName;
    private String studentfilesSex;
    private String studentfilesAge;
    private String studentfilesPhone;
    private String parentPhone;
    private String studentfilesSchool;
    private String studentfilesLoc;
    private Date studentfilesTime;
    private String staffName;
    private int staffId;
    private String studentfilesRemarks;
    private int studentfilesState;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date studentfilesBirthday;

}

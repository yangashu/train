package com.trkj.train.TyVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//学员毕业查询
public class ectGraduationDo {
    private int graduationId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date graduationDate;
    private int studentId;
    private String studentName;
    private String studentSex;
    private int studentAge;
    private String studentPhone;
    private String studentLoc;
    private int classesId;
    private String classesName;
}

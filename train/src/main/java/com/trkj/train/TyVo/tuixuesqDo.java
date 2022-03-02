package com.trkj.train.TyVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class tuixuesqDo {
    private Integer leaveschoolId;
    private Integer studentId;
    private String studentName;
    private String studentSex;
    private Integer studentAge;
    private String studentPhone;
    private String parentPhone;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date leaveschoolDate;
    private String leaveschoolReason;

}

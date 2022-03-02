package com.trkj.train.TyVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class recruitStudentHonorDo {
    private Integer studenthonorId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date studenthonorDate;
    private String studenthonorContent;
    private Integer studentId;
    private String studentName;
    private Integer classesId;
    private String classesName;
}

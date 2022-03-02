package com.trkj.train.TyVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class punishDo {
    private String student_name;
    private Integer stundentpunishId;
    private Integer stundentpunishGrade;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date stundentpunishDate;
    private String stundentpunishReason;
    private Integer studentId;

}

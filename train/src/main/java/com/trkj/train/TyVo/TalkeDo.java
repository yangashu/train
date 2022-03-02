package com.trkj.train.TyVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalkeDo {
    private Integer studentId;
    private String studentName;
    private Integer staffId;
    private String staffName;
    private String studenttalkContent;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date studenttalkDate;
    private Integer studenttalkId;
}

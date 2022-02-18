package com.trkj.train.TyVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EctTimetablepkDo {
    private int timetableId;
    private Date timetableTime;
    private String timetableMorning;
    private int staffId1;
    private String staffName;
    private int classesId;
    private String className;
    private int timetableState;
}

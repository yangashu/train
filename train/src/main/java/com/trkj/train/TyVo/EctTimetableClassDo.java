package com.trkj.train.TyVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EctTimetableClassDo {
    private int timetableId;
    private String timetable_morning;
    private Date timetable_time;
    private Date timetable_date;
    private int classes_id;
    private int staff_id1;
    private String staffname;
    private int timetable_state;
}

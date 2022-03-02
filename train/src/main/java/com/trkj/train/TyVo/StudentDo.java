package com.trkj.train.TyVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDo {
    private int student_id;//学员编号
    private String student_name;//学员姓名
    private String student_sex;//学员性别
    private String student_age;//学员年龄

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date student_birthday;//出生年月
    private String student_phone;//联系电话
    private String parent_phone;//家长电话
    private String student_school;//学员毕业学校
    private String student_loc;//学生住址
    private int classes_id;//班级外键
    private String classes_name;//班级名称
    private int course_id;//课程外键
    private String course_name;//课程名字

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date student_entrance;//入学时间
    private int staff_id;//咨询师
    private String staff_name;
}

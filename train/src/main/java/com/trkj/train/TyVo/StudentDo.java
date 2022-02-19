package com.trkj.train.TyVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDo {
    private int student_id;//学员编号
    private String student_name;//学员姓名
    private String student_sex;//学员性别
    private String student_age;//学员年龄
    private String student_birthday;//出生年月
    private String student_phone;//联系电话
    private String parent_phone;//家长电话
    private String student_school;//学员毕业学校
    private String student_loc;//学生住址
    private int classes_id;//班级外键
    private String classes_name;//班级名称
    private int course_id;//课程外键
    private String course_name;//课程名字
    private String student_entrance;//入学时间
    private int staff_id;//咨询师
}

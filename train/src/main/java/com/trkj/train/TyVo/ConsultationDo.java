package com.trkj.train.TyVo;

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
public class ConsultationDo {
    //    咨询登记表格分页查询
//    学员id
    private int studentFiles_id;
    //    学员名字
    private String studentFiles_name;
    //    学员性别
    private String studentFiles_sex;
    //    学员年龄
    private String studentFiles_age;
    // 学员出生年月
    private Date studentFiles_birthday;
    //    学员联系电话
    private String studentFiles_phone;
    //   学员家长联系电话
    private String parent_phone;
    //    学员毕业学校
    private String studentFiles_school;
    //    学员住址
    private String studentFiles_loc;
    //    备注
    private String studentFiles_remarks;
    //    学员状态
    private int studentFiles_state;
    //    课程名字
    private String course_name;
    //    员工名字（接待人）
    private String staff_name;
    //    课程id
    private int course_id;
    //    员工id
    private int staff_id;
    //  时间
    private Date studentFiles_time;
}

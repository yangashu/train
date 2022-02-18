package com.trkj.train.TyVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * @author ty
 * @date 2021/12/25
 */
@Data
public class ClassesManageDO {
    /**
     * 班级id
     */
    private int classesId;
    /**
     * 班级名称
     */
    private String classesName;
    /**
     * 教室名称
     */
    private String classRoomName;
    /**
     * 班主任
     */
    private String staffName;
    /**
     * 班级人数
     */
    private String classesNumber;
    /**
     * 课程
     */
    private String courseName;
    /**
     * 课时
     */
    private Integer courseHour;
    /**
     * 剩余课时
     */
    private Integer classesHour;;
    /**
     * 开班时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date classesDate;
}

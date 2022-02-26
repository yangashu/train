package com.trkj.train.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class staffAndPersonalAndLeave {

    private int leaveId;//请假表编号

    private int staffId1;//请假人Id

    private String personalName1;//请假人姓名

    private String personalPhone;//请假人联系电话

    private String personalMail;//请假人联系邮箱

    private String leaveContent;//请假原因

    private Date beginTime;//请假开始时间

    private Date endTime;//请假结束时间

    @JsonFormat(pattern = "yyyy年MM月dd日 HH时",timezone = "GMT+8")
    private Date beginTime1;//请假开始时间

    @JsonFormat(pattern = "yyyy年MM月dd日 HH时",timezone = "GMT+8")
    private Date endTime1;//请假结束时间

    private int leaveState;//状态 0：未通过，1：已通过

    private int staffId2=0;//批准人Id

    private String personalName2="等待审批";//批准人姓名，若还未批准则为待审批
}

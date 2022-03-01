package com.trkj.train.entity.vo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class staffAndPersonalAndBusiness {

    private int staffBusiness;//出差id

    private int staffId1;//出差人id

    private String personalName1;//出差人姓名

    private String personalPhone;//出差人联系电话

    private String personalMail;//出差人联系邮箱

    private String staffBusinessContent;//出差原因

    private Date beginTime;//请假开始时间

    private Date endTime;//请假结束时间

    @JsonFormat(pattern = "yyyy年MM月dd日 HH时",timezone = "GMT+8")
    private Date beginTime1;//请假开始时间

    @JsonFormat(pattern = "yyyy年MM月dd日 HH时",timezone = "GMT+8")
    private Date endTime1;//请假结束时间

    private String staffBusinessState;//出差状态是否通过

    private int staffId2=0;//批准人Id

    private String personalName2="等待审批";//批准人姓名，若还未批准则为待审批
}

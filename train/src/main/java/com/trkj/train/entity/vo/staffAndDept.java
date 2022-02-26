package com.trkj.train.entity.vo;

import com.trkj.train.entity.SysDept;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class staffAndDept {
    private int deptId;

    private String deptName;

    private Date deptTime;

    private int deptParentid;

    private String parentName;

    private List<SysDept> list=new ArrayList<>();

    private int count;
}

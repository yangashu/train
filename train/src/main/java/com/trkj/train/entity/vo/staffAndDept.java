package com.trkj.train.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class staffAndDept {
    private int deptId;

    private String deptName;

    private String staffName;

    private String staffPhone;

    private int count;
}

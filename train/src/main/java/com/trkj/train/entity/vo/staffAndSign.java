package com.trkj.train.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class staffAndSign {
    private int signId;

    private int signState;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date signDate;

    private int staffId;

    private String personalName;

    private String personalPhone;
}

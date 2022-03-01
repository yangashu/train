package com.trkj.train.config.dto.domain;

import lombok.Data;

@Data
public class AliPay {

    private String subject;
    private String traceNo;
    private String totalAmount;
    private int staffId;
    private String remarks;

}

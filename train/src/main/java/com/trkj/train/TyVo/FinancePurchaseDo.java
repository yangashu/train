package com.trkj.train.TyVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinancePurchaseDo {
    private int purchaseId;
    private String purchaseName;
    private int purchaseAount;
    private int staffId;
    private String staffName;
    private int courseId;
    private String courseName;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date purchaseDate;
    private int purchaseNumber;
    private Integer inwarehouseId;
    private Integer warehouseId;
}

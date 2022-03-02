package com.trkj.train.TyVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class warehouseDo {
    private Integer warehouseId;
    private Integer outwarehouseId;
    private Integer outwarehouseNumber;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date outwarehouseTime;
    private Integer classes_id;
    private String classesName;
    private Integer staffId;
    private String staffName;
    private String warehouseName;
}

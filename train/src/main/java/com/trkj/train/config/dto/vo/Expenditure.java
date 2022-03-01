package com.trkj.train.config.dto.vo;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.trkj.train.entity.EctRefund;
import com.trkj.train.entity.FinanceExpenditure;
import com.trkj.train.entity.FinancePurchase;
import com.trkj.train.entity.SysStaff;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FINANCE_EXPENDITURE")
@ApiModel(value="FinanceExpenditure对象", description="")
public class Expenditure extends FinanceExpenditure implements Serializable {

    @TableField(exist = false)
    private FinancePurchase financePurchase;
    @TableField(exist = false)
    private EctRefund ectRefund;
    @TableField(exist = false)
    private SysStaff staff;
    @TableField(exist = false)
    private SysStaff drawingrepeat;
}

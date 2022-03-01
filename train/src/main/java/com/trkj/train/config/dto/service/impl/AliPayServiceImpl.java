package com.trkj.train.config.dto.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.train.config.dto.domain.AliPay;
import com.trkj.train.config.dto.mapper.RefundAndLeaveSchoolAndStudentAndStaffMapper;
import com.trkj.train.config.dto.service.IAliPayService;
import com.trkj.train.config.dto.vo.RefundAndLeaveSchoolAndStudentAndStaffVo;
import com.trkj.train.entity.EctRefund;
import com.trkj.train.entity.FinanceExpenditure;
import com.trkj.train.mapper.EctRefundMapper;
import com.trkj.train.mapper.FinanceExpenditureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Transactional
@Service
public class AliPayServiceImpl implements IAliPayService{

    @Autowired
    private RefundAndLeaveSchoolAndStudentAndStaffMapper mapper;
    @Autowired
    private EctRefundMapper refundMappermapper;
    @Autowired
    private FinanceExpenditureMapper expenditureMapper;

    private int userid;
    private String remarks;
    @Override
    public String pay(AliPay aliPay) {
        userid=aliPay.getStaffId();
        remarks=aliPay.getRemarks();
        AlipayTradePagePayResponse response;
        RefundAndLeaveSchoolAndStudentAndStaffVo ectRefund = mapper.findByid(aliPay.getTraceNo());
        System.err.println(ectRefund);
        try {
            //  发起API调用（以创建当面付收款二维码为例）
            response = Factory.Payment.Page()
                    .pay(ectRefund.getStudentName(), ectRefund.getRefundId()+"",ectRefund.getRefundMoney()+"", "");
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
        return response.getBody();
    }

    @Override
    public String alinotify(HttpServletRequest request) throws Exception {
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");

            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
                System.out.println(name + " = " + request.getParameter(name));
            }
            EctRefund Refund = refundMappermapper.selectById(params.get("out_trade_no"));

            String tradeNo = params.get("out_trade_no");
            String gmtPayment = params.get("gmt_payment");
            String money = params.get("invoice_amount");
            double aDouble=Double.valueOf(money);
            FinanceExpenditure financeExpenditure = new FinanceExpenditure();
            financeExpenditure.setRefundId(Integer.parseInt(tradeNo));
            financeExpenditure.setStaffId(userid);
            financeExpenditure.setExpenditureMode(2);
            financeExpenditure.setRemarks(remarks);
            financeExpenditure.setDrawing(Refund.getStaffId());
            financeExpenditure.setExpenditureDate(new Date());
            financeExpenditure.setExpenditureMoney((int)aDouble);
            EctRefund ectRefund = new EctRefund();

            ectRefund.setRefundId(Integer.parseInt(tradeNo));
            ectRefund.setRefundDate(new Date());
            ectRefund.setRefundMoney((int)aDouble);
            ectRefund.setRefundState(0);

            try {
                refundMappermapper.updateById(ectRefund);
                expenditureMapper.insert(financeExpenditure);

            } catch (Exception e) {
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                throw new Exception("操作失败！");

            }
//             更新订单未已支付
            // 支付宝验签
//            if (Factory.Payment.Common().verifyNotify(params)) {
//
//                // 验签通过
//                System.out.println("交易名称: " + params.get("subject"));
//                System.out.println("交易状态: " + params.get("trade_status"));
//                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
//                System.out.println("商户订单号: " + params.get("out_trade_no"));
//                System.out.println("交易金额: " + params.get("total_amount"));
//                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
//                System.out.println("买家付款时间: " + params.get("gmt_payment"));
//                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));
//            }
        }
        return "success";
    }



    @Override
    public boolean saveBatch(Collection entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Object entity) {
        return false;
    }

    @Override
    public Object getOne(Wrapper queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper getBaseMapper() {
        return null;
    }

    @Override
    public Class getEntityClass() {
        return null;
    }

    @Override
    public Object getObj(Wrapper queryWrapper, Function mapper) {
        return null;
    }
}

package com.trkj.train.config.dto.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.AliPay;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.vo.PayAndStaffAndstudentVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IAliPayService extends IService {

    String alinotify(HttpServletRequest request) throws Exception;

    String pay(AliPay aliPay);
}

package com.trkj.train.config.dto.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.config.dto.vo.PayAndStaffAndstudentVo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface IPayAndStaffAndstudentService  extends IService<PayAndStaffAndstudentVo> {
    Result<PayAndStaffAndstudentVo> paging(Map<String,Object> map);

    Result export(HttpServletResponse response, Paging paging) throws Exception;

    Result saveAll(MultipartFile excelFile) throws Exception;

    Result updateBatchbyid(List<Integer> ids);

    Result exportByid(HttpServletResponse response, int id) throws Exception;
}

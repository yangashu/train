package com.trkj.train.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.config.dto.domain.Paging;
import com.trkj.train.entity.FinanceExpenditure;
import com.trkj.train.mapper.FinanceExpenditureMapper;
import com.trkj.train.service.IFinanceExpenditureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
public class FinanceExpenditureServiceImpl extends ServiceImpl<FinanceExpenditureMapper, FinanceExpenditure> implements IFinanceExpenditureService {

    @Autowired
    private FinanceExpenditureMapper mapper;

    @Override
    public Result paging(Map<String, Object> map) {
        Paging paging = JSON.parseObject(JSON.toJSONString(map.get("Paging")), Paging.class);
        return Result.success(mapper.selectPage(new Page<>(paging.getCurrentPage(),paging.getPageSize()),null));
    }
}

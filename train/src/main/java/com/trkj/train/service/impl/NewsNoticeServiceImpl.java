package com.trkj.train.service.impl;

import com.trkj.train.entity.NewsNotice;
import com.trkj.train.mapper.NewsNoticeMapper;
import com.trkj.train.service.INewsNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
public class NewsNoticeServiceImpl extends ServiceImpl<NewsNoticeMapper, NewsNotice> implements INewsNoticeService {

    @Autowired
    private NewsNoticeMapper mapper;

    @Override
    public int one() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        List<NewsNotice> list=mapper.selectList(null);
        List<NewsNotice> list1=new ArrayList<>();
        for(NewsNotice n : list){
            String newDate=format.format(new Date());
            String oldDate=n.getNoticeDate().toString().substring(0,10);
            if (newDate.equals(oldDate)){
                list1.add(n);
            }else {
                continue;
            }
        }
        return list1.size();
    }
}

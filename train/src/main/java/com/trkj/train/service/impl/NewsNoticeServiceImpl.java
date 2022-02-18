package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.dto.NoticeView;
import com.trkj.train.config.dto.SendView;
import com.trkj.train.entity.NewsNotice;
import com.trkj.train.entity.PersonalSend;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.NewsNoticeMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.service.INewsNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    private NewsNoticeMapper newsNoticeMapper;

    @Autowired
    private SysStaffMapper staffMapper;

    @Override
    public IPage<NoticeView> pageselect(int page, int size) {
        QueryWrapper queryWrapper=new QueryWrapper();
        Page<NewsNotice> page1=new Page<>(page,size);
        IPage<NewsNotice> iPage = newsNoticeMapper.selectPage(page1,queryWrapper);
        IPage<NoticeView> viewIPage = new Page<>();
        List<NoticeView> list = new ArrayList();

        for(int i=0;i<iPage.getRecords().size();i++){
            QueryWrapper<SysStaff> queryWrapper1 = new QueryWrapper();
            queryWrapper1.eq("staff_id",iPage.getRecords().get(i).getStaffId());
            SysStaff personal = staffMapper.selectOne(queryWrapper1);
            NoticeView noticeView = new NoticeView();
            noticeView.setNoticeId(iPage.getRecords().get(i).getNoticeId());
            noticeView.setNoticeDate(iPage.getRecords().get(i).getNoticeDate());
            noticeView.setNoticeContent(iPage.getRecords().get(i).getNoticeContent());
            noticeView.setNoticeType(iPage.getRecords().get(i).getNoticeType());
            noticeView.setNoticeTheme(iPage.getRecords().get(i).getNoticeTheme());
            noticeView.setStaffName(personal.getStaffName());
            noticeView.setDeleted(iPage.getRecords().get(i).getDeleted());
            noticeView.setState(iPage.getRecords().get(i).getState());
            list.add(noticeView);
        }
        viewIPage.setCurrent(iPage.getCurrent());
        viewIPage.setPages(iPage.getPages());
        viewIPage.setRecords(list);
        viewIPage.setSize(iPage.getSize());
        viewIPage.setTotal(iPage.getTotal());
        return viewIPage;
    }

    @Override
    public int xiugai(NewsNotice newsNotice) {
        if (newsNotice.getState()==0){
            newsNotice.setState(1);
        }else if(newsNotice.getState()==1){
            newsNotice.setState(0);
        }
        return newsNoticeMapper.updateById(newsNotice);
    }
}

package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.dto.NoticeView;
import com.trkj.train.config.dto.SendView;
import com.trkj.train.entity.*;
import com.trkj.train.mapper.NewsNoticeMapper;
import com.trkj.train.mapper.SysPositionMapper;
import com.trkj.train.mapper.SysStaffMapper;
import com.trkj.train.mapper.SysStaffPositionMapper;
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

    @Autowired
    private SysStaffPositionMapper sysStaffPositionMapper;

    @Autowired
    private SysPositionMapper sysPositionMapper;

    @Override
    public IPage<NoticeView> pageselectLike(int page, int size, String like, String mode) {
        QueryWrapper<NewsNotice> queryWrapper = new QueryWrapper<>();
        if (mode.equals("公告主题")){
            queryWrapper.like("notice_theme",like);
        }else if(mode.equals("公告内容")){
            queryWrapper.like("notice_content",like);
        }
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
    public IPage<NoticeView> pageselect(int page, int size,int id) {
        QueryWrapper<SysStaffPosition> queryWrapper = new QueryWrapper();
        queryWrapper.eq("STAFF_ID",id);
        List<SysStaffPosition> list1 = sysStaffPositionMapper.selectList(queryWrapper);

        QueryWrapper<SysPosition> sysPositionQueryWrapper = new QueryWrapper<>();
        queryWrapper.eq("POSITION_ID",list1.get(0).getPositionId());
        SysPosition sysPosition = sysPositionMapper.selectOne(sysPositionQueryWrapper);


        Page<NewsNotice> page1=new Page<>(page,size);
        IPage<NewsNotice> iPage = newsNoticeMapper.selectPage(page1,new QueryWrapper<NewsNotice>().eq("dept_id",sysPosition.getDeptId()));
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

    //修改为发布
    @Override
    public int xiugai(int id) {
        NewsNotice newsNotice1 = newsNoticeMapper.selectById(id);
        newsNotice1.setState(1);
        return newsNoticeMapper.updateById(newsNotice1);
    }

    //修改为暂停
    @Override
    public int zanting(int id) {
        NewsNotice newsNotice1 = newsNoticeMapper.selectById(id);
        newsNotice1.setState(0);
        return newsNoticeMapper.updateById(newsNotice1);
    }

    @Override
    public int del(int id) {
        return newsNoticeMapper.deleteById(id);
    }

    @Override
    public int add(NewsNotice newsNotice) {
        newsNotice.setNoticeContent(newsNotice.getNoticeContent());
        newsNotice.setNoticeTheme(newsNotice.getNoticeTheme());
        newsNotice.setNoticeType(newsNotice.getNoticeType());
        newsNotice.setStaffId(newsNotice.getStaffId());
        newsNotice.setDeptId(newsNotice.getDeptId());
        newsNotice.setState(0);
        return newsNoticeMapper.insert(newsNotice);
    }
}

package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.entity.RecruitChannel;
import com.trkj.train.mapper.RecruitChannelMapper;
import com.trkj.train.service.IRecruitChannelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Transactional
@Service
public class RecruitChannelServiceImpl extends ServiceImpl<RecruitChannelMapper, RecruitChannel> implements IRecruitChannelService {
    @Autowired
    private RecruitChannelMapper channelMapper;
    //    分页
    @Override
    public IPage<RecruitChannel> page(int page, int size) {
        Page<RecruitChannel> page1=new Page<>(page,size);
        IPage<RecruitChannel> iPage=channelMapper.selectPage(page1,null);
        return iPage;
    }
    //添加渠道
    @Override
    public int addqudao(RecruitChannel channel) {
        try {
            int addqudaos=channelMapper.insert(channel);
            return addqudaos;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
    //修改渠道
    @Override
    public int updatequdao(RecruitChannel channel) {
        try {
            return channelMapper.updateById(channel);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
    //    根据渠道名称分页查询
    @Override
    public IPage<RecruitChannel> likeselect(int page, int size, String channelName) {
        Page<RecruitChannel> pageqqq=new Page<>(page,size);
        QueryWrapper<RecruitChannel> wrapper=new QueryWrapper<>();
        wrapper.like("CHANNEL_NAME",channelName).orderByDesc("CHANNEL_ID");
        IPage<RecruitChannel> channelIPage=channelMapper.selectPage(pageqqq,wrapper);
        return channelIPage;
    }

    @Override
    public int delectchannel(RecruitChannel channel) {
        try {
            return channelMapper.deleteById(channel);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public List<RecruitChannel> selectqd() {
        return channelMapper.selectList(null);
    }
}

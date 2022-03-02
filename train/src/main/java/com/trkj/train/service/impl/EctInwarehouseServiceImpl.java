package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.FinancePurchaseDo;
import com.trkj.train.entity.EctInwarehouse;
import com.trkj.train.mapper.EctInwarehouseMapper;
import com.trkj.train.service.IEctInwarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
public class EctInwarehouseServiceImpl extends ServiceImpl<EctInwarehouseMapper, EctInwarehouse> implements IEctInwarehouseService {
    @Autowired
    private EctInwarehouseMapper ectInwarehouseMapper;


    @Override
    public int insertrkjc(EctInwarehouse ectInwarehouse) {
        try {
            return ectInwarehouseMapper.insert(ectInwarehouse);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public IPage<FinancePurchaseDo> selectiptionjc(int page, int size, int deleted, String shoushuokuan) {
        Page page1=new Page(page,size);
        QueryWrapper queryWrapper=new QueryWrapper();
        if (deleted==0){
            queryWrapper.like("e.DELETED",deleted);
            if (shoushuokuan!=null && shoushuokuan.length()!=0){
                queryWrapper.like("f.purchase_name",shoushuokuan);
            }
        }
        IPage<FinancePurchaseDo> paaaa=ectInwarehouseMapper.selectiptionssrk(page1,queryWrapper);
        System.out.println("assdffhjhj："+paaaa.getTotal());
        return paaaa;
    }
}

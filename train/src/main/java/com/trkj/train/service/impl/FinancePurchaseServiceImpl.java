package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.FinancePurchaseDo;
import com.trkj.train.entity.FinancePurchase;
import com.trkj.train.mapper.FinancePurchaseMapper;
import com.trkj.train.service.IFinancePurchaseService;
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
public class FinancePurchaseServiceImpl extends ServiceImpl<FinancePurchaseMapper, FinancePurchase> implements IFinancePurchaseService {
    @Autowired
    private FinancePurchaseMapper financePurchaseMapper;
//    @Override
//    public IPage<FinancePurchaseDo> selectcgjc(int page, int size) {
//        IPage<FinancePurchaseDo> page1=financePurchaseMapper.selectcgjc(new Page<>(page,size));
//        return page1;
//    }

//    @Override
//    public IPage<FinancePurchaseDo> selectiptionjc(int page, int size, int deleted, String shoushuokuan) {
//        Page page1=new Page(page,size);
//        QueryWrapper queryWrapper=new QueryWrapper();
//        if (deleted==0){
//            queryWrapper.like("f.DELETED",deleted);
//            if (shoushuokuan!=null&&shoushuokuan.length()!=0){
//                queryWrapper.like("f.purchase_name",shoushuokuan);
//            }
//        }
//        IPage<FinancePurchaseDo> paaaa=financePurchaseMapper.selectiptionss(page1,queryWrapper);
//        return paaaa;
//    }

    @Override
    public int insertjcrk(FinancePurchase financePurchase) {
        try {
            int a=financePurchaseMapper.insert(financePurchase);
            return (financePurchase.getPurchaseId());
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public int updatejcrk(FinancePurchase financePurchase) {
        try {
            return financePurchaseMapper.updateById(financePurchase);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}

package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.entity.EctInwarehouse;
import com.trkj.train.entity.EctWarehouse;
import com.trkj.train.mapper.EctWarehouseMapper;
import com.trkj.train.service.IEctWarehouseService;
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
public class EctWarehouseServiceImpl extends ServiceImpl<EctWarehouseMapper, EctWarehouse> implements IEctWarehouseService {
    @Autowired
    private EctWarehouseMapper ectWarehouseMapper;


    @Override
    public int insertckkctable(EctWarehouse ectWarehouse) {
        try {
            int ada=ectWarehouseMapper.insert(ectWarehouse);
            return (ectWarehouse.getWarehouseId());
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public int updatejcck(EctWarehouse ectWarehouse) {
        try {
            return ectWarehouseMapper.updateById(ectWarehouse);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public List<EctWarehouse> selectNamejc() {
        return ectWarehouseMapper.selectNameck();
    }

    @Override
    public int updatekcNumber(EctWarehouse ectWarehouse) {
        try {
            return ectWarehouseMapper.updateckNumber(ectWarehouse);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public IPage<EctWarehouse> selectckcx(int page, int size, int deleted, String ckshoushuokuan) {
        Page page1=new Page(page,size);
        QueryWrapper<EctWarehouse> queryWrapper=new QueryWrapper<>();
        if (deleted==0){
            queryWrapper.like("deleted",deleted);
            if (ckshoushuokuan!=null && ckshoushuokuan.length()!=0){
                queryWrapper.like("WAREHOUSE_NAME",ckshoushuokuan);
            }
        }
        IPage<EctWarehouse> page2=ectWarehouseMapper.selectPage(page1,queryWrapper);
        return page2;
    }
}

package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.warehouseDo;
import com.trkj.train.entity.EctOutwarehouse;
import com.trkj.train.mapper.EctOutwarehouseMapper;
import com.trkj.train.service.IEctOutwarehouseService;
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
public class EctOutwarehouseServiceImpl extends ServiceImpl<EctOutwarehouseMapper, EctOutwarehouse> implements IEctOutwarehouseService {
    @Autowired
    private EctOutwarehouseMapper ectOutwarehouseMapper;


    @Override
    public IPage<warehouseDo> selectwarehousedo(int page, int size, String shoushuokuanchuku, int deleted) {
        Page page1=new Page(page,size);
        QueryWrapper<warehouseDo> queryWrapper=new QueryWrapper<>();
        if (deleted==0){
            queryWrapper.like("e.deleted",deleted);
            if (shoushuokuanchuku!=null && shoushuokuanchuku.length()!=0){
                queryWrapper.like("w.warehouse_name",shoushuokuanchuku);
            }
        }
        IPage<warehouseDo> page2=ectOutwarehouseMapper.selectwarehouse(page1,queryWrapper);

        return page2;
    }

    @Override
    public int insertckjc(EctOutwarehouse ectOutwarehouse) {
        try {
            return ectOutwarehouseMapper.insert(ectOutwarehouse);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
}

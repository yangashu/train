package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.ClassesManageDO;
import com.trkj.train.config.Result;
import com.trkj.train.entity.EctClasses;
import com.trkj.train.mapper.EctClassesMapper;
import com.trkj.train.service.IEctClassesService;
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
public class EctClassesServiceImpl extends ServiceImpl<EctClassesMapper, EctClasses> implements IEctClassesService {
    @Autowired
    private EctClassesMapper classesMapper;

    @Override
    public Page<ClassesManageDO> selectClasses(ClassesManageDO classesManageDO, int page, int size) {
        Page<ClassesManageDO> pageSelect=new Page<>(page,size);
        return classesMapper.selectClasses(pageSelect,null);
    }

//    @Override
//    public List<ClassesManageDO> selectCl() {
//        List<ClassesManageDO> selectlist=classesMapper.selectClasses();
//        return selectlist;
//    }

    @Override
    public Result paging(Page<ClassesManageDO> page) {

        return Result.success("0","",classesMapper.paging(page));

    }

    //添加班级
    @Override
    public int inserclass(EctClasses classes) {
        try {
            return classesMapper.insert(classes);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
    //修改
    @Override
    public int updateclass(EctClasses classes) {
        try {
            return classesMapper.updateById(classes);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }
    //查询所有
    @Override
    public List<EctClasses> selectsyclass() {
        return classesMapper.selectList(new LambdaQueryWrapper<EctClasses>());
    }

    @Override
    public IPage<ClassesManageDO> selectiptionclas(int page, int size, String input, String downOne, String downThree,int deleted) {
        Page<ClassesManageDO> pages=new Page<>(page,size);
        QueryWrapper queryWrapper=new QueryWrapper();
        if(deleted==0) {
            queryWrapper.eq("s.deleted", deleted);
            if (input != null && input.length() != 0) {
                queryWrapper.eq("s.classes_name", input);
            }
            if (downOne != null && downOne.length() != 0) {
                queryWrapper.eq("s.staff_id", downOne);
            }

            if (downThree != null && downThree.length() != 0) {
                queryWrapper.eq("s.classroom_id", downThree);
            }
        }
        IPage<ClassesManageDO> pageaa=classesMapper.selectiptionclass(pages,queryWrapper);

        return pageaa;
    }

    @Override
    public List<EctClasses> selectipionbj() {
        return classesMapper.selectiptionclassss();
    }

    @Override
    public int deleteclass(EctClasses ectClasses) {
        try {
            return classesMapper.deleteById(ectClasses);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public Result findByid(int id) {

        return Result.success(classesMapper.findByid(id));
    }
}

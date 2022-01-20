package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysDept;
import com.trkj.train.entity.SysPosition;
import com.trkj.train.mapper.SysDeptMapper;
import com.trkj.train.mapper.SysPositionMapper;
import com.trkj.train.service.ISysPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
public class SysPositionServiceImpl extends ServiceImpl<SysPositionMapper, SysPosition> implements ISysPositionService {

    @Autowired
    private SysPositionMapper mapper;
    @Autowired
    private SysDeptMapper deptMapper;

    //    分页查询
    @Override
    public Result<?> selectpage(Page<SysPosition> sysPositionPage, String keyword) {


        QueryWrapper<SysPosition> wrapper = new QueryWrapper<>();
        wrapper.like("position_name", keyword);
        IPage<SysPosition> iPage = mapper.selectPage(sysPositionPage, wrapper);

        List<SysDept> depts=deptMapper.selectList(null);
        for (SysDept dept : depts) {
            for (SysPosition record : iPage.getRecords()) {
                if (dept.getDeptId()==record.getDeptId()){
                    record.getDepts().add(dept);
                }
            }
        }
        if (iPage.getRecords().size() == 0) {
            return Result.error("-1", "没有你想要的数据");
        } else {
            return Result.success("200","yes",iPage);
        }
    }

    @Override
    public Result<?> findByid(int id) {
        if (Objects.isNull(mapper.selectById(id))){
            return Result.error("-1","没有查到你所需要的数据");
        }
        return Result.success(mapper.selectById(id));
    }

    @Override
    public Result deleteById(int id) {
        if (mapper.deleteById(id)>0){
            return Result.success("200","操作成功！！！",null);
        }
        return Result.error("-1","操作失败,该数据可能已被移除！！！");
    }

    @Override
    public Result deleteBatchIds(List<Integer> ids) {

        if(mapper.deleteBatchIds(ids)>0){
            return Result.success("200","操作成功！！！",null);
        }
        return Result.error("-1","操作失败！！！");
    }
}

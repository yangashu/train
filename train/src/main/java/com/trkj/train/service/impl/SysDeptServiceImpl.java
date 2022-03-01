package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.entity.SysDept;
import com.trkj.train.entity.SysPosition;
import com.trkj.train.entity.vo.staffAndDept;
import com.trkj.train.mapper.SysDeptMapper;
import com.trkj.train.mapper.SysPositionMapper;
import com.trkj.train.mapper.SysStaffPositionMapper;
import com.trkj.train.service.ISysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    @Autowired
    private SysDeptMapper mapper;

    @Autowired
    public SysDeptMapper mapper;

    @Autowired
    public SysPositionMapper positionMapper;

    @Autowired
    public SysStaffPositionMapper spMapper;

    @Override
    public List<SysDept> selectDeptList() {
        return mapper.selectList(new QueryWrapper<SysDept>().orderByAsc("dept_id"));
    }

    @Override
    public List<SysDept> selectDeptList() {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.ne("dept_id",0);
        wrapper.orderByAsc("dept_id");
        return mapper.selectList(wrapper);
    }

    @Override
    //查询全部部门分页方法
    public IPage<staffAndDept> one(int page, int size) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.ne("dept_id",0);
        queryWrapper.orderByAsc("dept_id");
        IPage<SysDept> iPage=mapper.selectPage(new Page(page,size),queryWrapper);
        IPage<staffAndDept> iPage1=new Page<>();
        List<staffAndDept> list=new ArrayList<>();
        int rs=0;
        for(int i=0;i<iPage.getRecords().size();i++){
            rs=0;
            int id=iPage.getRecords().get(i).getDeptId();
            QueryWrapper<SysPosition> q=new QueryWrapper<>();
            q.eq("dept_id",id);
            List<SysPosition> list1=positionMapper.selectList(q);
            for(SysPosition p: list1){
                QueryWrapper qw=new QueryWrapper();
                qw.eq("position_id",p.getPositionId());
                rs=rs+spMapper.selectCount(qw);
            }
            staffAndDept sd=new staffAndDept();
            sd.setDeptId(id);
            sd.setDeptName(iPage.getRecords().get(i).getDeptName());
            sd.setDeptTime(iPage.getRecords().get(i).getDeptTime());
            sd.setDeptParentid(iPage.getRecords().get(i).getDeptParentid());
            int parentId=iPage.getRecords().get(i).getDeptParentid();
            if(parentId==0){
                sd.setParentName("教育培训机构");
            }else{
                SysDept dept=mapper.selectOne(new QueryWrapper<SysDept>().eq("dept_id",parentId));
                sd.setParentName(dept.getDeptName());
            }

            for (SysDept dept:iPage.getRecords()){
                if(dept.getDeptParentid()==iPage.getRecords().get(i).getDeptParentid()){
                    sd.getList().add(dept);
                }
            }
            sd.setCount(rs);
            list.add(sd);
        }
        iPage1.setCurrent(iPage.getCurrent());
        iPage1.setSize(iPage.getSize());
        iPage1.setPages(iPage.getPages());
        iPage1.setTotal(iPage.getTotal());
        iPage1.setRecords(list);
        return iPage1;
    }

    @Override
    public List<SysDept> three() {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.ne("dept_id",0);
        wrapper.orderByAsc("dept_id");
        return mapper.selectList(null);
    }

    @Override
    //添加部门方法
    public Result two(String deptName,int deptParentid) {
        SysDept dept=new SysDept();
        dept.setDeptName(deptName);
        dept.setDeptParentid(deptParentid);
        List<SysDept> list=this.three();
        boolean jg=false;
        for(SysDept d : list){
            if(d.getDeptName().equals(dept.getDeptName())){
                jg=false;
                break;
            }else{
                jg=true;
            }
        }
        if(jg){
            mapper.insert(dept);
            return Result.success("0","添加成功",null);
        }else {
            return Result.error("-1","该部门已存在，换个名字吧！");
        }
    }

    //修改部门方法
    @Override
    public Result four(int id,String deptName,int deptParentid) {
        SysDept dept=new SysDept();
        dept.setDeptName(deptName);
        dept.setDeptParentid(deptParentid);
        List<SysDept> list=this.three();
        boolean jg=false;
        for(SysDept d : list){
            if(d.getDeptName().equals(dept.getDeptName())){
                if(d.getDeptId()==id){

                }else{
                    jg=false;
                    break;
                }

            }else{
                jg=true;
            }
        }
        if(jg){
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("dept_id",id);
            int i=mapper.update(dept,queryWrapper);
            return Result.success("0","修改成功",null);
        }else {
            return Result.error("-1","该部门已存在，换个名字吧！");
        }
    }

    //删除方法
    @Override
    public Result five(int id) {
        List<SysDept> list=mapper.selectList(new QueryWrapper<SysDept>().eq("dept_parentid",id));
        if(list.size()==0){
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("dept_id",id);
            mapper.delete(queryWrapper);
            return Result.success("0","删除成功！",null);
        }else{
            return Result.success("1","该部门有子部门存在，无法删除！",null);
        }
    }


    //模糊查询方法
    public IPage<staffAndDept> six(Page page, String deptName){
        QueryWrapper<SysDept> queryWrapper=new QueryWrapper();
        queryWrapper.ne("dept_id",0);
        queryWrapper.like("dept_name",deptName);
        IPage<SysDept> iPage=mapper.selectPage(page,queryWrapper);
        IPage<staffAndDept> iPage1=new Page<>();
        List<staffAndDept> list=new ArrayList<>();
        int rs=0;
        for(int i=0;i<iPage.getRecords().size();i++){
            rs=0;
            int id=iPage.getRecords().get(i).getDeptId();
            QueryWrapper<SysPosition> q=new QueryWrapper<>();
            q.eq("dept_id",id);
            List<SysPosition> list1=positionMapper.selectList(q);
            for(SysPosition p: list1){
                QueryWrapper qw=new QueryWrapper();
                qw.eq("position_id",p.getPositionId());
                rs=rs+spMapper.selectCount(qw);
            }
            staffAndDept sd=new staffAndDept();
            sd.setDeptId(id);
            sd.setDeptName(iPage.getRecords().get(i).getDeptName());
            sd.setDeptTime(iPage.getRecords().get(i).getDeptTime());
            sd.setDeptParentid(iPage.getRecords().get(i).getDeptParentid());
            int parentId=iPage.getRecords().get(i).getDeptParentid();
            if(parentId==0){
                sd.setParentName("教育培训机构");
            }else{
                SysDept dept=mapper.selectOne(new QueryWrapper<SysDept>().eq("dept_id",parentId));
                sd.setParentName(dept.getDeptName());
            }

            for (SysDept dept:iPage.getRecords()){
                if(dept.getDeptParentid()==iPage.getRecords().get(i).getDeptParentid()){
                    sd.getList().add(dept);
                }
            }
            sd.setCount(rs);
            list.add(sd);
        }
        iPage1.setCurrent(iPage.getCurrent());
        iPage1.setSize(iPage.getSize());
        iPage1.setPages(iPage.getPages());
        iPage1.setTotal(iPage.getTotal());
        iPage1.setRecords(list);
        return iPage1;
    }

}

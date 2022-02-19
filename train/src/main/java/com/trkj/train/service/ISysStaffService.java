package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.entity.SysStaff;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.train.entity.vo.staffAndPersonal;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-18
 */
public interface ISysStaffService extends IService<SysStaff> {
    public IPage<SysStaff> paging(Page<SysStaff> page, String search);

    Result insert(Map<String, Object> map);

    Result findByid(int id);

    Result<?> deleteBatchIds(List<Integer> ids);

    Result<?> deleteById(int id);

    public IPage<staffAndPersonal> two(int page, int size);

    public IPage<staffAndPersonal> selectFace(int page,int size);

    public Result updateFace(int userId,String url) throws Exception;

    public IPage<staffAndPersonal> five(Page page,String like);

    public int three(int staffId);

    public int six(staffAndPersonal sap);

    public int four(int staffId);

    public String selectStaffName();


    //  班级管理  添加班级弹框  班主任下拉框  查询是班主任职位的员工
    List<SysStaff> insertstaff();
    //咨询登记   跟进人下拉框搜索   查询是咨询师职位的员工
    List<SysStaff> selectgjr();
    //    学员中心   在读学员   上课老师下拉框查询
    List<SysStaff> selectclassteacher();
}

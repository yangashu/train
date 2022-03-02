package com.trkj.train.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.ClassesManageDO;
import com.trkj.train.entity.EctClasses;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface EctClassesMapper extends BaseMapper<EctClasses> {
    //    分页
    Page<ClassesManageDO> selectClasses(Page<ClassesManageDO> page,
                                        @Param("ew") Wrapper<ClassesManageDO> queryWrapper);


    @Select("select * from ect_classes a\n" +
            "            left join ect_classroom b on a.CLASSROOM_ID = b.CLASSROOM_ID\n" +
            "            left join sys_staff c on a.STAFF_ID = c.STAFF_ID\n" +
            "            LEFT JOIN recruit_course r on a.course_id=r.course_id\n" +
            "\t\t\t\t\t\twhere a.DELETED=0")
    IPage<ClassesManageDO> paging(Page<ClassesManageDO> page);

//    班级管理  搜索
    IPage<ClassesManageDO> selectiptionclass(Page page,@Param(Constants.WRAPPER) QueryWrapper<ClassesManageDO> consultationDOQueryWrapper);

    ClassesManageDO findByid(@Param("id") int id);

//    排课管理  添加弹框 班级下拉框查询
    @Select("SELECT * FROM ect_classes e WHERE e.DELETED=0")
    List<EctClasses> selectiptionclassss();

}

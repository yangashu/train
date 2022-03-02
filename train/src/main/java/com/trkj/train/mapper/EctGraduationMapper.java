package com.trkj.train.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.StudentDo;
import com.trkj.train.TyVo.ectGraduationDo;
import com.trkj.train.entity.EctGraduation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface EctGraduationMapper extends BaseMapper<EctGraduation> {
//学员中心  历史学员查询
    IPage<ectGraduationDo> selectHistory(Page<ectGraduationDo> page);
//    学员中心  历史学员搜索查询
    IPage<ectGraduationDo> selectiptionhistory(Page page,@Param(Constants.WRAPPER) QueryWrapper<ectGraduationDo> consultationDOQueryWrapper);

}

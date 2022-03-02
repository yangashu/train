package com.trkj.train.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.recruitStudentHonorDo;
import com.trkj.train.entity.RecruitStudenthonor;
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
public interface RecruitStudenthonorMapper extends BaseMapper<RecruitStudenthonor> {
//学员中心  详情弹框 学员荣誉查询
    IPage<recruitStudentHonorDo> studentry(Page page,@Param("studentId") int studentId);
}

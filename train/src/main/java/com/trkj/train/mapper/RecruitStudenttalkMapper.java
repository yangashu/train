package com.trkj.train.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.StudentDo;
import com.trkj.train.TyVo.TalkeDo;
import com.trkj.train.entity.RecruitStudenttalk;
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
public interface RecruitStudenttalkMapper extends BaseMapper<RecruitStudenttalk> {
// 学员谈话表查询
        IPage<TalkeDo> selecttalk(Page page,@Param("studentId") int studentId);
}

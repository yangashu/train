package com.trkj.train.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.punishDo;
import com.trkj.train.entity.RecruitStundentpunish;
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
public interface RecruitStundentpunishMapper extends BaseMapper<RecruitStundentpunish> {
// 查询处分表
    IPage<punishDo> selectpunish(Page page,@Param("studentId") int studentId);
}

package com.trkj.train.mapper;

import com.trkj.train.entity.CantonSatffsign;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Mapper
public interface CantonSatffsignMapper extends BaseMapper<CantonSatffsign> {

    @Update("UPDATE canton_satffsign s SET s.SIGN_DATE=SYSDATE,s.SIGN_STATE=1 WHERE s.STAFF_ID=#{StaffID}")
    public int one(int StaffID);
}

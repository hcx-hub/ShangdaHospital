package com.gaogao.houduan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gaogao.houduan.entity.Yuyue;
import org.apache.ibatis.annotations.Param;

public interface YuyueMapper extends BaseMapper<Yuyue> {
    //    //一对多查询，查询该医生的预约
    Page<Yuyue> findselfPage(Page<Yuyue> page,@Param("doctorId") Integer doctorId);
//    //查询所有预约
    Page<Yuyue> findallPage(Page<Yuyue> page);
}

package com.gaogao.houduan.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gaogao.houduan.common.Result;
import com.gaogao.houduan.entity.Yuyue;
import com.gaogao.houduan.mapper.YuyueMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/yuyue")
public class YuyueController {

    @Resource
    YuyueMapper yuyueMapper;

    @PostMapping
    public Result<?> save(@RequestBody Yuyue yuyue) {
        yuyueMapper.insert(yuyue);
        return Result.success();
    }
    
    @PutMapping
    public Result<?> update(@RequestBody Yuyue yuyue) {
        yuyueMapper.updateById(yuyue);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Long id) {
        yuyueMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {

        LambdaQueryWrapper<Yuyue> wrapper=Wrappers.<Yuyue>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.like(Yuyue::getDoctorId,search);
        }
        Page<Yuyue> yuyuePage = yuyueMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(yuyuePage);
    }


}

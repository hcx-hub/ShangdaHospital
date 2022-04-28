package com.gaogao.houduan.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gaogao.houduan.common.Result;
import com.gaogao.houduan.entity.Doctor;
import com.gaogao.houduan.mapper.DoctorMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Resource
    DoctorMapper doctorMapper;



    @PostMapping("/login")
    public Result<?> login(@RequestBody Doctor doctor) {
        Doctor res = doctorMapper.selectOne(Wrappers.<Doctor>lambdaQuery().eq(Doctor::getUsername, doctor.getUsername()).eq(Doctor::getPassword, doctor.getPassword()));
        if (res==null){
            return Result.error("-1","用户名或密码错误");
        }
        return Result.success(res);
    }
    @PostMapping("/register")
    public Result<?> register(@RequestBody Doctor doctor) {
        Doctor res = doctorMapper.selectOne(Wrappers.<Doctor>lambdaQuery().eq(Doctor::getUsername, doctor.getUsername()));
        if (res!=null){
            return Result.error("-1","用户名已存在");
        }
        doctorMapper.insert(doctor);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Doctor doctor) {
        doctorMapper.updateById(doctor);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Long id) {
        doctorMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping("/loadall")
    public Result<?> loadAll(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize)
    {

        LambdaQueryWrapper<Doctor> wrapper=Wrappers.<Doctor>lambdaQuery();
        Page<Doctor> doctorPage = doctorMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(doctorPage);
    }
    @GetMapping("/findbyname")
    public Result<?> findByname(@RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "") String search) {

        LambdaQueryWrapper<Doctor> wrapper=Wrappers.<Doctor>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.eq(Doctor::getDoctorName,search);
        }
        Page<Doctor> doctorPage = doctorMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(doctorPage);
    }

}

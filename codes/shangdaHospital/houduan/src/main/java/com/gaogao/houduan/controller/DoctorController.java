package com.gaogao.houduan.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gaogao.houduan.common.Result;
import com.gaogao.houduan.entity.Doctor;
import com.gaogao.houduan.entity.User;
import com.gaogao.houduan.mapper.DoctorMapper;
import com.gaogao.houduan.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Resource
    UserMapper userMapper;
    @Resource
    DoctorMapper doctorMapper;


    @PostMapping
    public Result<?> save(@RequestBody User user) {
        if (user.getPassword() == null) {
            user.setPassword("123");
        }
        userMapper.insert(user);
        Integer docid = user.getId();
        String docname = user.getRealName();
        Doctor doctor = new Doctor();
        doctor.setDoctorId(docid);
        doctor.setDoctorName(docname);
        doctorMapper.insert(doctor);
        return Result.success();
    }


    @PutMapping
    public Result<?> update(@RequestBody User user) {
        userMapper.updateById(user);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Long id) {
        userMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search) {

        LambdaQueryWrapper<User> wrapper=Wrappers.<User>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.like(User::getRealName,search);
        }
        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }

}

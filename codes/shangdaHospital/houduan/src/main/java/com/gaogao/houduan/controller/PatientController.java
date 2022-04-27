package com.gaogao.houduan.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gaogao.houduan.common.Result;
import com.gaogao.houduan.entity.Patient;
import com.gaogao.houduan.mapper.PatientMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Resource
    PatientMapper patientMapper;


//    @PostMapping
//    public Result<?> save(@RequestBody Doctor doctor) {
//        if (doctor.getPassword() == null) {
//            doctor.setPassword("123");
//        }
//        doctorMapper.insert(doctor);
//        Integer docid = doctor.getId();
//        String docname = doctor.getRealName();
//        Doctor doctor = new Doctor();
//
//        doctor.setDoctorName(docname);
//        doctorMapper.insert(doctor);
//        return Result.success();
//    }
//    @PostMapping("/login")
//    public Result<?> login(@RequestBody Doctor doctor) {
//        Doctor res = doctorMapper.selectOne(Wrappers.<Doctor>lambdaQuery().eq(Doctor::getUsername, doctor.getUsername()).eq(Doctor::getPassword, doctor.getPassword()));
//        if (res==null){
//            return Result.error("-1","用户名或密码错误");
//        }
//        return Result.success(res);
//    }
//    @PostMapping("/register")
//    public Result<?> register(@RequestBody Doctor doctor) {
//        Doctor res = doctorMapper.selectOne(Wrappers.<Doctor>lambdaQuery().eq(Doctor::getUsername, doctor.getUsername()));
//        if (res!=null){
//            return Result.error("-1","用户名已存在");
//        }
//
//        doctorMapper.insert(doctor);
//        return Result.success();
//    }

    @PutMapping
    public Result<?> update(@RequestBody Patient patient) {
        patientMapper.updateById(patient);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result<?> delete(@PathVariable Long id) {
        patientMapper.deleteById(id);
        return Result.success();
    }


    @GetMapping("/loadall")
    public Result<?> loadAll(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize)
    {

        LambdaQueryWrapper<Patient> wrapper=Wrappers.<Patient>lambdaQuery();
        Page<Patient> patientPage = patientMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(patientPage);
    }
    @GetMapping("/findbyname")
    public Result<?> findByname(@RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "") String search) {

        LambdaQueryWrapper<Patient> wrapper=Wrappers.<Patient>lambdaQuery();
        if (StrUtil.isNotBlank(search)){
            wrapper.eq(Patient::getPatientName,search);
        }
        Page<Patient> patientPage = patientMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(patientPage);
    }

}

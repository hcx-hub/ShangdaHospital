package com.gaogao.houduan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//预约
@TableName("yuyue")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Yuyue {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer patientId;
    private Integer doctorId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date time;

//    //TableField注解表示数据库不存在的字段，而java需要使用，加上这个注解就不会报错
    @TableField(exist = false)
    private List<Doctor> doctorList;
    @TableField(exist = false)
    private List<Patient> patientList;
}

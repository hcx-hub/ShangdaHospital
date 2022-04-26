package com.gaogao.houduan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

//预约
@TableName("yuyue")
@Data
@AllArgsConstructor
public class Yuyue {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String patientId;
    private String patientName;
    private String doctorId;
    private String doctorName;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date time;
    private String department;
}

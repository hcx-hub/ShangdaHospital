package com.gaogao.houduan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("doctor")
@Data
public class Doctor {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer doctorId;
    private String doctorName;
    private String department;
}

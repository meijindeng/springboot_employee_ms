package com.dmj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String deptName;
}

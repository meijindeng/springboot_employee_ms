package com.dmj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//员工表
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String empName;
    private String email;
    private Integer sex; //0-女，1-男

    private Department department;
    private Date birthday;

    public Employee(Integer id, String empName, String email, Integer sex, Department department) {
        this.id = id;
        this.empName = empName;
        this.email = email;
        this.sex = sex;
        this.department = department;
        this.birthday = new Date();//自定义有参构造，默认创建日期
    }
}

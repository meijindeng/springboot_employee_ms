package com.dmj.controller;

import com.dmj.entity.Department;
import com.dmj.entity.Employee;
import com.dmj.mapper.DepartmentMapper;
import com.dmj.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    //controller调service层
    //这里我们调dao层
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeMapper.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
        //查出所有部门信息
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("save==>"+employee);
        //添加的操作
        employeeMapper.save(employee);//调用底层业务方法保存员工信息
        return "redirect:/emps";//提交成功，返回到emps
    }

    //跳转员工修改页面
    @GetMapping("")
    public String toUpdateEmp(){
        //查出原来的数据
        return "emp/update";
    }
}

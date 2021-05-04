package com.dmj.mapper;

import com.dmj.entity.Department;
import com.dmj.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeMapper {

    //模拟数据库操作
    private static Map<Integer, Employee> employees = null;
    //员工所属部门
    @Autowired
    private DepartmentMapper departmentMapper;
    static {
        employees = new HashMap<Integer, Employee>();//创建一个部门表
        employees.put(1001,new Employee(1001,"AAA","111222@qq.com",1,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BBB","111222@qq.com",0,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CCC","111222@qq.com",1,new Department(103,"运营部")));
        employees.put(1004,new Employee(1004,"DDD","111222@qq.com",0,new Department(104,"教研部")));
        employees.put(1005,new Employee(1005,"EEE","111222@qq.com",1,new Department(105,"后勤部")));
    }

    //主键自增
    private static Integer initId = 1006;

    //增加一个员工（两个会变）
    public void save(Employee employee){
        //1、主键自增
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        //2、部门管理外键
        employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工4
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}

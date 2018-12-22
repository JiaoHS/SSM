package com.jiao.service.impl;

import com.jiao.bean.Employee;
import com.jiao.bean.EmployeeExample;
import com.jiao.dao.EmployeeMapper;
import com.jiao.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther coraljiao
 * @date 2018/12/22 14:06
 * @description
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmps() {
        return employeeMapper.selectByExample(null);
    }

    @Override
    public List<Employee> getAll(Integer num) {
        List<Employee> employeesList=null;
        employeesList=new ArrayList<>();
        employeesList.add(new Employee(1001, "E-AA", "1", "aa@163.com", 7));
        employeesList.add(new Employee(1002, "E-BB", "0", "bb@163.com", 6));
        employeesList.add(new Employee(1003, "E-CC", "1", "cc@163.com", 6));
        employeesList.add(new Employee(1004, "E-DD", "1", "dd@163.com", 6));
        employeesList.add(new Employee(1005, "E-EE", "1", "ee@163.com", 6));
        return (List<Employee>)employees.values();
    }


    private static Map<Integer, Employee> employees = null;

    private static List<Employee> employeesList=null;


    static {
        //employees = new HashMap<Integer, Employee>();
        employeesList=new ArrayList<>();
        employeesList.add(new Employee(1001, "E-AA", "1", "aa@163.com", 7));
        employeesList.add(new Employee(1002, "E-BB", "0", "bb@163.com", 6));
        employeesList.add(new Employee(1003, "E-CC", "1", "cc@163.com", 6));
        employeesList.add(new Employee(1004, "E-DD", "1", "dd@163.com", 6));
        employeesList.add(new Employee(1005, "E-EE", "1", "ee@163.com", 6));
    }

    Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getEmpId() == null) {
            employee.setEmpId(initId++);
        }

        employee.setdId(6);
        employees.put(employee.getEmpId(), employee);
    }
//    @Override
//    public List<Employee> getAll() {
//        return (List<Employee>)employees.values();
//    }

    public Employee get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }


}

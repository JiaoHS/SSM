package com.jiao.service;

import com.jiao.bean.Employee;
import com.jiao.bean.EmployeeExample;
import com.jiao.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther coraljiao
 * @date 2018/12/20 11:16
 * @description
 */
public interface EmployeeService {
    List<Employee> getAllEmps();

    List<Employee> getAll(Integer num);
}

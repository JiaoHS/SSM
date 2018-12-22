package com.jiao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiao.bean.Employee;
import com.jiao.bean.Msg;
import com.jiao.service.EmployeeService;
import com.jiao.service.impl.EmployeeServiceImpl;
import com.jiao.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther coraljiao
 * @date 2018/12/20 11:14
 * @description
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //    @RequestMapping("/empss")
//    public String getAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
//
////        //这是一个分页查询
////        //引入pageHelper插件
////        //在查询钱只需调用传入页码以及分页每页大小
////        PageHelper.startPage(pn,5);
////        //startPage后面紧跟的这个查询就是分页查询
////        List<Employee> emps = employeeService.getAll();
////        //pageinfo封装了分页的详细信息，包括查出来的数据  5表示传入连续显示的页数
////        PageInfo page = new PageInfo(emps,5);
////        model.addAttribute("pageInfo",page);
//        return "list";
//    }
    @RequestMapping("/empss")
    @ResponseBody
    public Msg getEmpsWithJson(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 这不是一个分页查询
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
//        PageHelper.startPage(pn, 5);
////        // startPage后面紧跟的这个查询就是一个分页查询
////        List<Employee> emps = employeeService.getAll();
////        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
////        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
////        PageInfo page = new PageInfo(emps, 5);

        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Employee> employees = employeeService.getAll(3);
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(employees, 5);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 查询员工数据（分页查询）
     *
     * @return
     */
    @RequestMapping(value = "/emps")
    public String getEmps(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            Model model) {
        // 这不是一个分页查询；
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Employee> emps = employeeService.getAllEmps();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        model.addAttribute("pageInfo", page);

        return "list";
    }
}

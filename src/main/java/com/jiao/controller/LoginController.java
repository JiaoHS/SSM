package com.jiao.controller;

import com.jiao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @auther coraljiao
 * @date 2018/12/21 16:48
 * @description
 */
@Controller
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "pn", defaultValue = "1") Integer pn, @RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session, Model model) {
        //List<UserInfo> userInfoList = userInfoService.getInfoByModel(userInfo);
        if (!username.isEmpty() && password.equals("123456")) {
            //返回用户信息并存入session
            session.setAttribute("username", username);

//            Collection<Employee> employees = userInfoServiceImpl.getAll();
//            model.addAttribute("userlist", employees);

//            PageHelper.startPage(pn, 5);
//            // startPage后面紧跟的这个查询就是一个分页查询
//            List<Employee> employees =(List<Employee>)userInfoServiceImpl.getAll();
//            // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
//            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
//            PageInfo page = new PageInfo(employees, 5);
//            return Msg.success().add("pageInfo", page);


            return "list2";
        } else {
            map.put("msg", "信息输入错误");
            return "/login";
        }

    }


}

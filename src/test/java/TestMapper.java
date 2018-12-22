
import com.jiao.bean.Department;
import com.jiao.bean.DepartmentExample;
import com.jiao.bean.Employee;
import com.jiao.dao.DepartmentMapper;
import com.jiao.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @auther coraljiao
 * @date 2018/12/20 09:29
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMapper {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    @Test
    public void TestCRUD() {
        //原生的测试
        //创建ioc容器
//        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
//        //从容器中获取mapper
//        DepartmentMapper bean=ioc.getBean(DepartmentMapper.class);
//        Department department = bean.selectByPrimaryKey(1);
//        System.out.println(department);

        //改为spring test
        //1、引入spring test依赖
        //2、加注解ContextConfigration 指定Spring的位置帮我们生成ioc容器 locations是个数组可以指定多个配置文件
        //3、RunWith Junit的注解，运行单元测试的时候可以选择运行哪个单元测试 SpringJUnit4ClassRunner.class是spring的测试模块
        //4、使用AUtowired要使用的组件即可
        Department department = departmentMapper.selectByPrimaryKey(1);
        List<Department> departments = departmentMapper.selectByExample(new DepartmentExample());
        List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
        System.out.println("ok");
//
//        System.out.println(department.getDeptId()+":"+department.getDeptName());
//       departmentMapper.insertSelective( new Department(null,"运维部"));
//        departmentMapper.insertSelective( new Department(null,"开发部"));

//        employeeMapper.insertSelective(new Employee(null,"dajiao","1","mrjiaohs@163.com",7));
//        employeeMapper.insertSelective(new Employee(null,"dashan","0","mrjiaohs@163.com",1));

//        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(1);
//        System.out.println(employee);
        //批量插入sqlSession
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        for (int i = 0; i < 1000; i++) {
//            String name = UUID.randomUUID().toString().substring(0,5)+i;
//            mapper.insertSelective(new Employee(null,name,"2",name+"@163.com",7));
//        }
//        System.out.println("批量完成");
    }
}

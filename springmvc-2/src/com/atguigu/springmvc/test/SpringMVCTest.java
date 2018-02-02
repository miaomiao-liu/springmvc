package com.atguigu.springmvc.test;

import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Created by miaomiao on 18-2-1.
 */
@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * Json: jar包：jackson-core-2.9.0.jar ， jackson-annotations-2.9.0.jar ， jackson-databind-2.9.0.jar
     *       直接返回需要的对象或集合
     *       加 @ResponseBody 注解
     */
    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }

    //自定义类型转换器
    @RequestMapping("/testConversionServiceConverter")
    public String testConverter(@RequestParam("employee")Employee employee){
        System.out.println("save:" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}

package com.atguigu.springmvc.test;

import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by miaomiao on 18-2-1.
 */
@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/testConversionServiceConverter")
    public String testConverter(@RequestParam("employee")Employee employee){
        System.out.println("save:" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}

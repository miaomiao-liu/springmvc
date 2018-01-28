package com.atguigu.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by miaomiao on 18-1-28.
 */
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";


    /**
     * REST:(资源)表现层状态转化
     * 以CRUD为例：
     * 新增：/order  Post
     * 删除：/order/1  Delete
     * 修改：/order/1  Put      update?id=1(之前)
     * 获取：/order/1  Get
     *
     * 如何发送PUT和DELETE请求：
     *    1.配置HiddenHttpMethodFilter
     *    2.发送Post请求，并且携带隐藏域（name="_method" , value为PUT或DELETE）
     */
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("testRest PUT:" + id);
        return SUCCESS;
    }


    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id){
        System.out.println("testRest DELETE:" + id);
        return SUCCESS;
    }


    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testRest(){
        System.out.println("testRest POST");
        return SUCCESS;
    }


    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("testRest GET:" + id);
        return SUCCESS;
    }


    //@PathVariable 可以映射URL中的占位符到目标方法的参数中
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value = "id") Integer id){
        System.out.println("testPathVariable" + id);
        return SUCCESS;
    }

    /**
     * 支持Ant风格的URL：?:匹配一个字符
     *                 *:匹配任意字符
     *                 **:匹配多层路径
     * @return
     */
    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath(){
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /**
     * 了解：可以使用params和headers更加精确的映射请求，可以支持简单的表达式
     * @return
     */
    @RequestMapping(value = "/testParamsAndHeaders",
            params = {"username","age!=12"},
            headers = {"Host=localhost:8080"})
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    //使用method属性来指定请求方法
    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}

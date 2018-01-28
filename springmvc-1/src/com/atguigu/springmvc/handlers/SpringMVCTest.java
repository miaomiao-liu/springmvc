package com.atguigu.springmvc.handlers;

import com.atguigu.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by miaomiao on 18-1-28.
 */
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

    /**
     * 可以使用Servlet原生的API作为目标方法的参数
     * 具体支持以下类型：
     *     HttpServletRequest
     *     HttpServletResponse
     *     HttpSession
     *     java.security.Principal
     *     Locale
     *     InputStream
     *     OutputStream
     *     Reader
     *     Writer
     *
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Writer out) throws IOException {
        System.out.println("testServletAPI , " + request + " , " +response);
        out.write("hello springmvc");
//        return SUCCESS;
    }

    /**
     * SpringMVC会按照请求参数名和POJO属性名进行自动匹配，
     * 自动为对象填充属性值，支持级联
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user){
        System.out.println("testPojo:" + user);
        return SUCCESS;
    }

    /**
     * 了解：
     * 映射一个Cookie值，用法同@RequestParam
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
        System.out.println("testCookieValue , JSESSIONID:" + sessionId);
        return SUCCESS;
    }

    /**
     * 了解：映射请求头信息，用法同@RequestParam
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al){
        System.out.println("testRequestHeader , Accept-Language:" + al);
        return SUCCESS;
    }

    /**
     * @RequestParam :来映射请求参数
     * value :请求参数名
     * required :该参数是否必须
     * defaultValue :请求参数的默认值
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String username,
                                   @RequestParam(value = "age",required = false,defaultValue = "0") Integer age){
        System.out.println("testRequestParam,username:" + username + "  age:" +age);
        return SUCCESS;
    }

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

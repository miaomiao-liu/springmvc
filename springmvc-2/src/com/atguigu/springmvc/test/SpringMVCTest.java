package com.atguigu.springmvc.test;

import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

/**
 * Created by miaomiao on 18-2-1.
 */
@Controller
public class SpringMVCTest {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/testSimpleMappingExceptionResolve")
    private String testSimpleMappingExceptionResolve(@RequestParam("i") int i){
        String[] vals = new  String[10];
        System.out.println(vals[i]);
        return "success";
    }


    /**
     * DefaultHandlerExceptionResolver : 对一些特殊的异常进行处理，
     * 以下是：只允许post请求，其他请求会出异常
     */
    @RequestMapping(value = "/testDefaultHandlerExceptionResolver",method = RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver(){
        System.out.println("testDefaultHandlerExceptionResolver");
        return "success";
    }


    @ResponseStatus(reason = "测试",value = HttpStatus.NOT_FOUND)
    @RequestMapping("/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
        if (i == 13){
            throw new UserNameNotMatchPasswordException();
        }
        System.out.println("testResponseStatusExceptionResolver...");
        return "success";
    }

//    @ExceptionHandler({RuntimeException.class})
//    public ModelAndView handlerArithmeticException2(Exception ex){
//        System.out.println("出异常了2： " + ex);
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception",ex);
//        return mv;
//    }


    /**
     * 1.在 @ExceptionHandler 方法的入参中可以加入 Exception 类型的参数，该参数即对应发生的异常对象
     * 2.@ExceptionHandler 方法的入参中不能传入 Map ，若希望把异常信息传到页面上，使用ModelAndView对象
     * 3.@ExceptionHandler 标记的方法有优先级的问题
     * 4.@ControllerAdvice : 如果当前 handler 中找不到 @ExceptionHandler 方法来处理当前方法出现的异常
     *   则将去 @ControllerAdvice 标记的类中查找 @ExceptionHandler 标记的方法来处理异常
     */
//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView handlerArithmeticException(Exception ex){
//        System.out.println("出异常了： " + ex);
////        return "error";
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception",ex);
//        return mv;
//    }



    @RequestMapping("/testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i){
        System.out.println("result : " + 10/i);
        return "success";
    }

    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String desc,
                                 @RequestParam("file")MultipartFile file) throws IOException {
        System.out.println("desc:" + desc);
        System.out.println("OriginalFileName:" + file.getOriginalFilename());
        System.out.println("InputStream:" + file.getInputStream());
        return "success";
    }

    @RequestMapping("/i18n")
    public String testI18n(Locale locale){
        String val = messageSource.getMessage("i18n.user",null,locale);
        System.out.println(val);
        return "i18n";
    }


    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/files/20000.doc");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=20000.doc");

        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body,headers,statusCode);
        return response;
    }

    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body){
        System.out.println(body);
        return "hello world !" + new Date();
    }

    /**
     * Json: jar包：jackson-core-2.9.0.jar ， jackson-annotations-2.9.0.jar ， jackson-databind-2.9.0.jar
     *       直接返回需要的对象或集合
     *       加 @ResponseBody 注解
     *       (HttpMassageConverter对象)
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

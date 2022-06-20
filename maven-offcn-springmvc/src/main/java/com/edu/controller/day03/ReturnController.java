package com.edu.controller.day03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
//springMvc的返回值类型
public class ReturnController {
    //视图解析器
    //http://localhost:6060/view
    @RequestMapping("/view")
    public String view(){
        return "main";
    }
    //重定向和转发
    //http://localhost:6060/forwardToView
    @RequestMapping("/forwardToView")
    public String forwardToView(){
        return "forward:/main.jsp";
    }
    //http://localhost:6060/redirectToView
    @RequestMapping("/redirectToView")
    public String redirectToView(){
        return "redirect:/test.jsp";
    }
    //modelAndView
    //http://localhost:6060/modelAndViewFor
    @RequestMapping("/modelAndViewFor")
    public ModelAndView modelAndViewFor(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","model and view");
        modelAndView.setViewName("value");
        return modelAndView;
    }
    //带值问题
    //forward可以带request作用域的值，但重定向是不可以的
    //使用session会导致服务器资源的浪费；我们采用这种方式
    //http://localhost:6060/redirectAndValue
    @RequestMapping("/redirectAndValue")
    public String redirectAndValue(RedirectAttributes redirectAttributes){
        //redirectAttributes.addFlashAttribute("msg","li lei");
        redirectAttributes.addAttribute("msg","li lei");
        return "redirect:processRedirectAndValue";
    }
    @RequestMapping("/processRedirectAndValue")
    public String processRedirectAndValue(@ModelAttribute(name = "msg") String msg){
        return "forward:/value.jsp";
    }
    //json返回值
    //http://localhost:6060/jsonTestMap
    @ResponseBody
    @RequestMapping("/jsonTestMap")
    public Map jsonTest(){
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i <10 ; i++) {
            map.put("guiHaoLe"+i,"1726891456"+i);
        }
        return map;
    }
}

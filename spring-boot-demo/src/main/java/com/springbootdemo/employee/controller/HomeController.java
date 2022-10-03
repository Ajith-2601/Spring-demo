package com.springbootdemo.employee.controller;

import com.springbootdemo.employee.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HomeController {

    @RequestMapping("/home")
    public String homePage()
    {
        return "Welcome Home Page!!!!!";
    }

    //@RequestMapping(value = "/user",method = RequestMethod.GET)//Complicated way
    //Rest Methods - Get,Post,Delete,Put
    @GetMapping("/user")
    public User user ()
    {
        User user = new User();
        user.setId(1L);
        user.setName("Ajith");
        user.setEmailId("ajithbkumar777@gmail.com");
        return user;
    }

    //PathVariable - If you need something do be defined in url(used when that particular information is mandatory information)
    // PathVariable is declared by /(slash)
    @GetMapping("/{id}/{id2}")
    public String pathVariable(@PathVariable String id,
                               @PathVariable("id2") String name)
    {
        return "The path variable is:" + id + ":" +name;

    }

    //RequestParams - used when that particular information is not andatory information
    //RequestParam is declared by (?) ie query parameters

    @GetMapping("/requestParams")
    public String requestParams(@RequestParam String name)
    {
        return "The requestParam name is:"+name;

    }
    //If you run localhost:8080/requestParams - its shows error becoz you need to define requestParam in url like localhost:8080/requestParams?name=Ajith



    //Requesting 2 request Parameters
//    @GetMapping("/requestParam")
//    public String requestParam(@RequestParam String name,
//                               @RequestParam String emailId)
//    {
//        return "The requestParam name is:"+ name + "and emailId :" +emailId;
//    }
    //localhost:8080/requestParams?name=Ajith&emailId=ajithb2601@gmail.com - works


//    @GetMapping("/requestParam")
//    public String requestParam(@RequestParam String name,
//                               @RequestParam(name="email") String emailId)
//    {
//        return "The requestParam name is:"+ name + " and emailId :" +emailId;
//
//    }
    //Instead of emailId pass oly email becoz that is what you have passed in @RequestParam(name="email")
    //localhost:8080/requestParams?name=Ajith&email=ajithb2601@gmail.com - works



    //Now if you dont pass email -  then it shows error but even if u dont pass email it should work for that you need to required = false
    //Now in this case you can observe emailId=null it's showing, if u dont want emailId to not to be null then give defaultValue =""
    @GetMapping("/requestParam")
    public String requestParam(@RequestParam String name,
                               @RequestParam(name="email",required = false,defaultValue = "") String emailId)
    {
        return "The requestParam name is:"+ name + " and emailId :" +emailId;

    }
}

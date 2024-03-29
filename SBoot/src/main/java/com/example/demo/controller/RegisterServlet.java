package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;


/**
 * 注册
 */
@Controller
public final class RegisterServlet {
	@Autowired 
	private UserService userService;
    /**
     * @return 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
	@RequestMapping(value="/register.do", method = RequestMethod.GET)
    protected String doPost(
    		 User user ,
    		ModelMap map
    		){
        boolean result = userService.createUser(user);
        if (result ) {
            map.addAttribute("msg", "注册成功"); 
        }else {
        	map.addAttribute("msg", "用户id已存在"); 
        }
        return "success";
	}
}

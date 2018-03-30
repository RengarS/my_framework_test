package com.aries.framework_test.controller;


import com.aries.aries_boot.annotation.Autowired;
import com.aries.aries_boot.annotation.Controller;
import com.aries.aries_boot.annotation.RequestMapping;
import com.aries.aries_boot.annotation.ResponseBody;
import com.aries.aries_boot.enums.RequestMethod;
import com.aries.aries_boot.resolvers.Model;
import com.aries.framework_test.domains.UserDO;
import com.aries.framework_test.service.UserService;

import java.io.File;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public UserDO get() {


        UserDO userDO = userService.getUserById("11111");

        System.out.println(userDO.getId() + "   " + userDO.getName() + "  " + userDO.getAge());
        return userDO;
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("welcome", "hello world");

        return "index";
    }
}

package com.aries.framework_test.controller;


import com.aries.aries_boot.annotation.*;
import com.aries.aries_boot.enums.RequestMethod;
import com.aries.aries_boot.resolvers.Model;
import com.aries.framework_test.service.UserService;
import com.aries.test.domain.UserDO;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(Model model) {

        model.addAttribute("welcome", "hello world");

        return "index";
    }

    @RequestMapping("/a/b")
    @ResponseBody
    public UserDO sdf() {
        UserDO userDO = userService.getUserById("11111");
        return userDO;
    }


    @RequestMapping(value = "/test/json", method = RequestMethod.POST)
    public void jsonParamTest(@RequestBody UserDO userDO) {
        System.out.println("用户id：" + userDO.getId() + "    " + "用户年龄：" + userDO.getAge() + "   " + "用户名字：" + userDO.getName());
    }

    @RequestMapping(value = "/test/get")
    public void getParamTest(@RequestParam("id") String id, @RequestParam("name") String name) {
        System.out.println("id:" + id + "   " + "name:" + name);
    }

    @RequestMapping(value = "/test/query/all")
    @ResponseBody
    public List<UserDO> list() {
        return userService.list();
    }

    @RequestMapping("/test/view")
    public String page(Model model) {
        model.addAttribute("users", userService.list());
        return "users";
    }

}

package com.aries.framework_test.controller;

import com.aries.aries_boot.annotation.*;
import com.aries.client.utils.AriesRpc;
import com.aries.test.domain.TestUser;
import com.aries.test.domain.UserDO;

import java.util.List;

@Controller
public class TestUserRpcController {
    @Autowired
    private AriesRpc ariesRpc;


    @RequestMapping("/user/getOne")
    @ResponseBody
    public TestUser getOne(@RequestParam("id") String id) throws Exception {
        System.out.println(id);
        return ariesRpc.requestSync("TEST-CUSTOMER", "GET-TEST-USER-ONE", id);
    }

    @RequestMapping("/user/all")
    @ResponseBody
    public List<UserDO> all() throws Exception {
        //调用serviceName为"TEST-CUSTOMER"服务的ServiceId为 "GET-TEST-USER-ALL"的方法
        return ariesRpc.requestSync("TEST-CUSTOMER", "GET-TEST-USER-ALL", "");
    }
}

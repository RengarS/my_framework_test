package com.aries.framework_test.service;

import com.aries.aries_boot.annotation.Autowired;
import com.aries.aries_boot.annotation.Bean;
import com.aries.aries_boot.annotation.Service;
import com.aries.client.utils.AriesRpc;
import com.aries.framework_test.repository.UserDAO;
import com.aries.test.domain.UserDO;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserDO getUserById(String id) {

        System.out.println(userDAO);

        return userDAO.getUserById(id);
    }

    public List<UserDO> list() {
        return userDAO.list();
    }

    /**
     * 将rpc客户端注入进容器
     * @return
     */
    @Bean
    public AriesRpc ariesRpc() {
        return new AriesRpc("127.0.0.1", 9999, true);
    }
}

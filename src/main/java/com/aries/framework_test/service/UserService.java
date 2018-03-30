package com.aries.framework_test.service;

import com.aries.aries_boot.annotation.Autowired;
import com.aries.aries_boot.annotation.Service;
import com.aries.framework_test.domains.UserDO;
import com.aries.framework_test.repository.UserDAO;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserDO getUserById(String id) {

        System.out.println(userDAO);

        return userDAO.getUserById(id);
    }
}

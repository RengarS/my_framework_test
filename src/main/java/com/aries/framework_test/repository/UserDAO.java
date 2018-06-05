package com.aries.framework_test.repository;


import com.aries.aries_boot.annotation.Repository;
import com.aries.test.domain.UserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Repository
public interface UserDAO {
    @Select("select * from user where id = #{id}")
    UserDO getUserById(@Param("id") String id);

    @Select("select * from user where 1=1")
    List<UserDO> list();
}

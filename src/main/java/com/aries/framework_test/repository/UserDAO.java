package com.aries.framework_test.repository;


import com.aries.aries_boot.annotation.Repository;
import com.aries.framework_test.domains.UserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Repository
public interface UserDAO {
    @Select("select * from user where id = #{id}")
    UserDO getUserById(@Param("id") String id);
}

package com.edu;

import com.edu.mapper.UserMapper;
import com.edu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MavenSelfBootApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        for (User user : userMapper.selectUserAll()) {
            System.out.println(user);
        }
    }

}

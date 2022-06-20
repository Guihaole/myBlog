package com.edu;

import com.edu.pojo.User;
import com.edu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class MyBatisPlusServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void testOne(){
        System.out.println(userService.count());
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i <10 ; i++) {
            User user = new User();
            user.setName("abc"+i);
            user.setAge(i);
            user.setEmail("203344314"+i+"@163.com");
            users.add(user);
        }
        System.out.println(userService.saveBatch(users));
    }
}

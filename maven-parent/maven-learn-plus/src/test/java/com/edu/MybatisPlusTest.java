package com.edu;

import com.edu.emens.SexEmen;
import com.edu.mapper.UserMapper;
import com.edu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import java.util.*;


@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testOne(){
        //List<User> userList = userMapper.selectList(null);
        //        User user = userMapper.selectById(1l);
        //        System.out.println(user);
        //        HashMap<String, Object> map = new HashMap<>();
        //        map.put("name","Jack");
        //        map.put("age",20);
        System.out.println("-------------------------");
        //        List<User> userList = userMapper.selectByMap(map);
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        System.out.println("-------------------------");
        //        Collection<Long> idList=new ArrayList<Long>();
        //        idList.add(3l);
        //        idList.add(4l);
        //        idList.add(5l);
        //        List<User> userList2 = userMapper.selectBatchIds(idList);
        //        userList2.forEach(System.out::println);
    }
    @Test
    public void testDelete(){
        System.out.println(userMapper.deleteById(1l));
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_name","Jack");
        map.put("age",20);
        System.out.println(userMapper.deleteByMap(map));
    }
    @Test
    public void testUpdate(){
        User user = new User(3l, "guihaole", null, null,null);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
    @Test
    public void testInsert(){
            //User user = new User( null,"guihaole", 1, "111111@qq.com",null);
            User user=new User(null,"guihaole",18, SexEmen.MEN,"20168893699@qq.com",0);
            System.out.println(userMapper.insert(user));
    //        Map<String, Object> map = userMapper.selectMapById(4l);
    //        Set<Map.Entry<String, Object>> entries = map.entrySet();
    //        entries.forEach(System.out::println);
    }
}

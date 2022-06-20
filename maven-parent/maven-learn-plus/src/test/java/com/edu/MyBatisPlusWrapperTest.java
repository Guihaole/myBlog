package com.edu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.edu.mapper.UserMapper;
import com.edu.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.function.Consumer;


@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
    @Test
    public void testOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    //按年龄降序查询用户，如果年龄相同则按id升序排列
    @Test
    public void testTwo() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("uid");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    //删除email为空的用户
    @Test
    public void testThree() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println(delete);
    }

    //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
    @Test
    public void testFour() {
        //构造修改条件
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.gt("age", 20)
                .like("user_name", "a")
                .or()
                .isNull("email");
        //修改的值
        User user = new User();
        user.setName("guiGeGe");
        user.setEmail("201996084006@QQ.com");
        System.out.println(userMapper.update(user, updateWrapper));
    }

    //-----------------------------------------------------------------
    //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
    @Test
    public void testFive() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        //lambda表达式的优先级最高
        updateWrapper.like("user_name", "a")
                .and(wrapper -> wrapper.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setName("guiGeGe");
        user.setEmail("201996084006@qq.com");
        userMapper.update(user, updateWrapper);
    }

    //查询id小于等于10的用户信息
    @Test
    public void testSix() {
        //子查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid", "select uid from s_user where uid <= 10");
        userMapper.selectList(queryWrapper);
    }

    //查询用户信息的username和age字段
    @Test
    public void testSeven() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name", "age", "email");
        userMapper.selectMaps(queryWrapper).forEach(System.out::println);
    }

    //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
    @Test
    public void testEight() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("user_name", "a")
                .and(wrapper -> wrapper.gt("age", 20).or().isNull("email"));
        updateWrapper.set("user_name", "java开发")
                .set("email", "2033443140@qq.com");
        userMapper.update(null, updateWrapper);
    }

    //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改  需要加上判断条件
    @Test
    public void testNine() {
        String username = "";
        Integer age = 18;
        String email = "201996084006@guigu.com";
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like(StringUtils.isNotBlank(username), "user_name", username)
                .and(wrapper -> wrapper.gt(age != null, "age", age).or().isNull("email"));
        updateWrapper.set(StringUtils.isNotBlank(email), "email", email);
        userMapper.update(null, updateWrapper);
    }
    //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
    @Test
    public void testTen(){
        String username="";
        Integer ageStart=20;
        Integer ageEnd=30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),"user_name",username)
                    .ge(ageStart!=null,"age",ageStart)
                    .le(ageEnd!=null,"age",ageEnd);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }
    //LambdaQueryWrapper
    @Test
    public void testTenOne(){
        String username="";
        Integer ageStart=20;
        Integer ageEnd=30;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                            .ge(User::getAge,ageStart)
                            .lt(User::getAge,ageEnd);
        //Function<User, String> function =(user)-> user.getName();
        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
        userList.forEach(System.out::println);
    }
    //LambdaUpdateWrapper
    @Test
    public void testTenTwo() {
        String username = "";
        Integer age = 18;
        String email = "201996084006@guigu.com";
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .and(wrapper -> wrapper.gt(age != null, User::getAge, age).or().isNull(User::getEmail));
        updateWrapper.set(StringUtils.isNotBlank(email),User::getEmail, email);
        userMapper.update(null, updateWrapper);
    }
}

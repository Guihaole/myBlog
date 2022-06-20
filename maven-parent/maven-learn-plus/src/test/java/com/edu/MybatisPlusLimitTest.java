package com.edu;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.mapper.ProductMapper;
import com.edu.mapper.UserMapper;
import com.edu.pojo.Product;
import com.edu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisPlusLimitTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    //测试自带分页
    @Test
    public void testOne() {
        Page<User> page = new Page<>(2, 3);
        userMapper.selectPage(page, null);
        System.out.println(page);
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }

    //测试自定义分页
    @Test
    public void testTwo() {
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPageLimit(page, 20);
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }

    //Mybatis中的乐观锁问题
    @Test
    public void testThree() {
        //小Li查询
        Product productLi = productMapper.selectById(1l);
        System.out.println(productLi);
        //小Wang查询
        Product productWang = productMapper.selectById(1l);
        System.out.println(productWang);
        //小Li修改
        productLi.setPrice(productLi.getPrice() + 50);
        int resultLi = productMapper.update(productLi, null);
        //小Wang修改
        productWang.setPrice(productWang.getPrice() - 30);
        int resultWang = productMapper.update(productWang, null);
        if (resultWang == 0) {
            Product product = productMapper.selectById(1l);
            product.setPrice(product.getPrice() - 30);
            productMapper.update(product, null);
        }
        //老板
        System.out.println(productMapper.selectById(1l).getPrice());
    }
    //乐观锁并发解决没有问题
    public int testLock(Integer price) {
        Product product = productMapper.selectById(1l);
        product.setPrice( product.getPrice() + price);
        return productMapper.update(product, null);
    }

}

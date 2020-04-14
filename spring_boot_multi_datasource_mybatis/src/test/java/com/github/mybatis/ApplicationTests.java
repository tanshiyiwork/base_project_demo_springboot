package com.github.mybatis;

import com.SpringBootMultiDataSourceApplication;
import com.github.mybatis.entity.User;
import com.github.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author JHON
 * @date 2020/04/08
 * @description:
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootMultiDataSourceApplication.class) //XxlJobExecutorApplication 为启动类
public class ApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("疯狂的");
        user.setPassword("888888");
        user.setPhoneNumber("1487544564");
        user.setStatus(1);
        user.setSalt("ascggeregeg");
        user.setEmail("asfdfefe@342");
        userService.addUser(user);
    }

    @Test
    public void testGetUserById() {
        User user = userService.getUserById("3");
        System.out.println(user.toString());
    }
}


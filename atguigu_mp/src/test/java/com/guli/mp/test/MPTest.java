package com.guli.mp.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.mp.mapper.UserMapper;
import com.guli.mp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MPTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectList() {
        List<User> user = userMapper.selectList(null);
        user.forEach(System.out::println);
    }

    @Test
    public void InsertUserTest() {
        User user = new User();
        user.setName("如花2");
        user.setAge(18);
        user.setEmail("1415865966@qq.com");
        userMapper.insert(user);

    }

    @Test
    public void UpdateUserTest() {
        User user = new User();
        user.setName("李四11");
        user.setId(5L);
        userMapper.updateById(user);

    }

    @Test
    public void updataById() {
        User user = userMapper.selectById(1154012969192779777L);
        user.setName("春花6");
        userMapper.updateById(user);
    }

    /*
    根据多个ID查询用户列表
     */
    @Test
    public void selectListById() {
//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//        list.add(2L);
//        list.add(3L);
//        list.add(4L);
        //List<User> users = userMapper.selectBatchIds(list);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1154012969192779777L);
        map.put("name", "春花4");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.err::println);
    }

    @Test
    public void userListPage() {
        Page<User> page = new Page<>(2, 4);
        IPage<User> page1 = userMapper.selectPage(page, null);
        List<User> users = page1.getRecords();
        users.forEach(System.err::println);
        System.out.println("当前页" + page.getCurrent());
        System.out.println("每页显示记录数" + page.getSize());
        System.out.println("总页数" + page.getPages());
        System.out.println("总记录数" + page.getTotal());
        System.out.println("是否有下一页" + page.hasNext());
        System.out.println("是否有上一页" + page.hasPrevious());
    }

    @Test
    public void deleteById() { //物理删除，在企业中用的少
        userMapper.deleteById(4L);
    }

    @Test
    public void deleteListById() {
        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(3L);
        userMapper.deleteBatchIds(list);

    }

    @Test
    public void wrapUserTest() {
        QueryWrapper wrapper = new QueryWrapper();
        Object wrappers = wrapper.ge("name", "如花1");
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);

    }
}

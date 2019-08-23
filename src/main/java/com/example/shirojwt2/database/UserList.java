package com.example.shirojwt2.database;

import com.example.shirojwt2.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库
 * @author 张威
 */
public class UserList {

    public static Map<String,User> userList = new HashMap<>();
    static {
        User user = new User("zhangwei","abc-123","admin","kkp");
        User dd = new User("dd","abc-123","role","dog");
        userList.put("zhangwei",user);
        userList.put("dd",dd);
    }
}

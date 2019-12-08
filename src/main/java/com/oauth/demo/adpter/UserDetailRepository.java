package com.oauth.demo.adpter;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:自定义
 * @author: Allen
 * @time: 2019/12/8 10:42
 */
public class UserDetailRepository {

    private Map<String, UserDetails> userDetailsMap = new HashMap<>();

    /**
     * 把UserDeteail中的用户创建，putIfAbsent:如果存在就不管，不存在就添加，不会替换value的值
     * @param user
     */
    public void createUser(UserDetails user){
        userDetailsMap.putIfAbsent(user.getUsername(),user);
    }

    public void updateUser(UserDetails user){

    }

    public void deleteUser(String var){

    }

   /* void changePassword(String var1, String var2);*/

    public boolean userExists(String var){
        if (userDetailsMap.containsKey(var)){
            return true;
        }
        return false;
    }
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDetailsMap.get(s);
    }
}

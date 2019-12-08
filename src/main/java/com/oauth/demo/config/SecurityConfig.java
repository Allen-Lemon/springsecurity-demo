package com.oauth.demo.config;

import com.oauth.demo.adpter.UserDetailRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * @description:
 * @author: Allen
 * @time: 2019/12/8 10:25
 */
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailRepository userDetailRepository(){
        UserDetailRepository userDetailRepository = new UserDetailRepository();
        //创建一个用户名为allen，密码不加密的root，authorities里面不能为空
         UserDetails user = User.withUsername("allen").password("root").authorities(AuthorityUtils.NO_AUTHORITIES).build();
         userDetailRepository.createUser(user);
            return userDetailRepository;
    }

    @Bean
   public UserDetailsManager userDetailsManager(UserDetailRepository userDetailRepository){
      return  new UserDetailsManager() {
          @Override
          public void createUser(UserDetails userDetails) {

          }

          @Override
          public void updateUser(UserDetails userDetails) {

          }

          @Override
          public void deleteUser(String s) {

          }

          @Override
          public void changePassword(String s, String s1) {

          }

          @Override
          public boolean userExists(String s) {
              return false;
          }

          @Override
          public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
              return userDetailRepository.loadUserByUsername(s);
          }
      };
    }
}

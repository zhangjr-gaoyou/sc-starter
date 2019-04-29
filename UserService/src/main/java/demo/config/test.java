package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

public class test {

	 /**
     * 设置用户密码的加密方式为MD5加密
     */
    @Bean
    public Md5PasswordEncoder customPasswordEncoder() {
        return new Md5PasswordEncoder();
    }

    /**
     *从数据库中读取用户信息
     */
    @Bean
    public UserDetailsService customUserService() {
        return new UserService();
    }
    
	
	
}

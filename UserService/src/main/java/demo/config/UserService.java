package demo.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		
    	CustomUserDetails ud = new CustomUserDetails();
    	ud.setUsername(s);
    	ud.setPassword("password");
    	
    	
    	
    	return ud;

    	

    }
}
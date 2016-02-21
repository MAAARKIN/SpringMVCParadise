package br.com.filhow.paradise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.filhow.paradise.model.CurrentUser;
import br.com.filhow.paradise.model.User;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
	
	 @Autowired private UserService userService;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
    	System.out.println("called");
        User user = userService.getUserByEmail(email);
        if (user == null) throw new UsernameNotFoundException("User with this email not found");
        return new CurrentUser(user);
    }
}

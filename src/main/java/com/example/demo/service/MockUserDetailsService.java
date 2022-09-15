package com.example.demo.service;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MockUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		// TODO Auto-generated method stub
		
		if (username.endsWith("admin") == false ) {
			throw new UsernameNotFoundException(username + " not found"); 
		}
		
		return new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return  username ;
			}
			
			@Override
			public String getPassword() {

				return "{noop}admin";
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				
				List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>() ;
				authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				return authorities;
			}
		};
	}

}

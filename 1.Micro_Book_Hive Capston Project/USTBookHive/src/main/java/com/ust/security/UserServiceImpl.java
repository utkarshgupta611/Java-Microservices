package com.ust.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.securityDto.AppUserDetails;
import com.ust.securityEntity.AppUser;
import com.ust.securityRepo.IUserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{

	@Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      AppUser user= userRepository.findByUsername(username);
      AppUserDetails desired=new AppUserDetails(user);
      return desired;
    }
}

package com.ust.securityDto;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ust.securityEntity.AppUser;

public class AppUserDetails implements UserDetails {

	private AppUser user;

    public AppUserDetails(AppUser user){
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      Set<GrantedAuthority> authorities=  user.getRoles().
                stream().
                map(role->new SimpleGrantedAuthority("ROLE_"+role.toUpperCase()))
           .collect(Collectors.toSet());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

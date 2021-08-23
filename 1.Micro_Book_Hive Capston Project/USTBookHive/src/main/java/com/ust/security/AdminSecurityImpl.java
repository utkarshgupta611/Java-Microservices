package com.ust.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.securityDto.CreateAdminRequest;
import com.ust.securityEntity.Admin;
import com.ust.securityEntity.AppUser;
import com.ust.securityRepo.IAdminRepository;
import com.ust.securityRepo.IUserRepository;

@Service
public class AdminSecurityImpl implements IAdminSecurity {

	@Autowired
    private IAdminRepository adminRepo;

    @Autowired
    private IUserRepository userRepo;

	
	@Override
	public Admin add(CreateAdminRequest request) {
		Admin admin=new Admin();
        admin.setFirstName(request.getFirstName());
        admin.setLastName(request.getLastName());
        AppUser user=new AppUser();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        Set<String> roles=new HashSet<>();
        roles.add("admin");
        user.setRoles(roles);
        user=userRepo.save(user);
        admin.setUser(user);
        return adminRepo.save(admin);
	}

	@Override
	public Admin findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

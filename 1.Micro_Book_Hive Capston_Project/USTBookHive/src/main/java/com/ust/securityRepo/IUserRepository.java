package com.ust.securityRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.securityEntity.AppUser;

public interface IUserRepository extends JpaRepository<AppUser, Long>{

	AppUser findByUsername(String username);
}

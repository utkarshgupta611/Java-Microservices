package com.ust.securityRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.securityEntity.Admin;

public interface IAdminRepository extends JpaRepository<Admin,Long>{

}

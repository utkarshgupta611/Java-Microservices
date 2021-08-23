package com.ust.security;

import com.ust.securityDto.CreateAdminRequest;
import com.ust.securityEntity.Admin;

public interface IAdminSecurity {

	Admin add(CreateAdminRequest request);

    Admin findById(Long id);
}

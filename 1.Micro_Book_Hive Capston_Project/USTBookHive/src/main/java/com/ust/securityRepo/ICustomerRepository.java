package com.ust.securityRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.securityEntity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long>{

}

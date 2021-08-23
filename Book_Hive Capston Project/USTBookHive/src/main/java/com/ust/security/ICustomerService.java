package com.ust.security;

import com.ust.securityDto.CreateCustomerRequest;
import com.ust.securityDto.CustomerDetails;
import com.ust.securityEntity.Customer;

public interface ICustomerService {

	CustomerDetails add(CreateCustomerRequest request);
    Customer findById(Long id);
}

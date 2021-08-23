package com.ust.security;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.exception.CustomerNotFoundException;
import com.ust.securityDto.CreateCustomerRequest;
import com.ust.securityDto.CustomerDetails;
import com.ust.securityEntity.AppUser;
import com.ust.securityEntity.Customer;
import com.ust.securityRepo.ICustomerRepository;
import com.ust.securityRepo.IUserRepository;
import com.ust.securityUtil.UserUtil;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
    private ICustomerRepository customerRepo;

    @Autowired
    private IUserRepository userRepo;

    @Autowired
    private UserUtil userUtil;

    @Override
    public CustomerDetails add(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        AppUser user = new AppUser();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        Set<String> roles = new HashSet<>();
        roles.add("customer");
        user.setRoles(roles);
        user = userRepo.save(user);
        customer.setUser(user);
        customer = customerRepo.save(customer);
        CustomerDetails details = userUtil.toCustomerDetails(customer);
        return details;
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> optional = customerRepo.findById(id);
        if (!optional.isPresent()) {
            throw new CustomerNotFoundException("customer not found");
        }
        return optional.get();
    }
}

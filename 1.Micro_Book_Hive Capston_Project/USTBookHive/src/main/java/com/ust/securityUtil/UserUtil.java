package com.ust.securityUtil;

import org.springframework.stereotype.Component;

import com.ust.securityDto.CustomerDetails;
import com.ust.securityEntity.Customer;

@Component
public class UserUtil {

	public CustomerDetails toCustomerDetails(Customer customer){
        CustomerDetails details=new CustomerDetails();
        details.setFirstName(customer.getFirstName());
        details.setLastName(customer.getLastName());
        details.setCustomerID(customer.getCustomerID());
        details.setUsername(customer.getUser().getUsername());
        return details;
    }
}

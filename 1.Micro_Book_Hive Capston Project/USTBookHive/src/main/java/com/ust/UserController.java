package com.ust;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/success")
    public String success(){
    	System.out.println("logging in");
        return "Successfully signed in, Now You Can Use BookHive";
    }
    @GetMapping("/logoutsuccess")
    public String appLogout(){
    	System.out.println("logging out");
        return "Successfully logged out";
    }
}

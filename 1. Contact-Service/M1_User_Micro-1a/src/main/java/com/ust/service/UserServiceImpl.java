package com.ust.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.entity.User;

@Service
public class UserServiceImpl implements UserService {

	//Fake User Must be Taken From DataBase
	List<User> list = List.of(
			new User(1231L, "Utkarsh", "9041120661"),
			new User(1232L, "arsh", "9041234543"),
			new User(1233L, "jishnu", "9041234566")
			);

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
	}

}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

@Transactional
@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	
	public User selectUser(User user){
		return  userMapper.selectUser(user.getUserName(), user.getPassword());
	}

	
	  public boolean createUser(User user) {

	        // 创建MyBatis的SQL会话。

	        // 创建Mapper对象。
	            // 判断是否有同名的user，若有则返回false。
	            User existingUser = userMapper.selectUser(user.getUserName(),user.getPassword());
	            if (existingUser == null) {
	                userMapper.createUser(user);
	            } else {
	                return false;
	            }
	        
	        return true;
	    }
	
}

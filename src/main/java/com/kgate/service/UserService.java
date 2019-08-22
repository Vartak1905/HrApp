package com.kgate.service;

import java.util.Date;
import java.util.List;

import com.kgate.entity.Attendence;
import com.kgate.entity.User;

public interface UserService 
{
	public User findUser(String email,String password,String userType);
	public User save(User user);
	public List<User> findAll();
	public User fetchPassword(String email);
	public List<Attendence> getAttendance(Date date);
	public List<User> findEmployee();
	

}
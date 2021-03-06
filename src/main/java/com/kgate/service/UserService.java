package com.kgate.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kgate.entity.Attendance;
import com.kgate.entity.Leave;
import com.kgate.entity.User;

public interface UserService {

	public List<Attendance> getAttendance(Date date);

	public User findUser(String email, String password);

	public User save(User user);

	public Leave save(Leave leave);

	public List<User> findEmployee();

	public User fetchPassword(String email);

	public Page<User> findEmployeePage(Pageable pageable);

	public Page<User> searchEmployee(Pageable pageable, String txt);

	public List<User> searchEmployee();

	public String findByEmail(String status);

	List<User> searchEmployee(String txt);

}

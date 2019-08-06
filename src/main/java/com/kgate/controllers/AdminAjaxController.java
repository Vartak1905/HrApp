package com.kgate.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kgate.entity.User;
import com.kgate.repository.UserRepository;

@Controller
public class AdminAjaxController {

	@Autowired
	UserRepository repo;
	
	 @RequestMapping(value = "/listEmp", method = RequestMethod.GET)
	 @ResponseBody
	    public Map<String, Object> viewlist() {
	        Map<String, Object> map = new HashMap<String, Object>();
	        List<User> userList = repo.findAll();
	        if(userList!=null) {
	        	map.put("list", userList);
	        }
	        else {
	        	map.put("msg", "Empty data");
	        }
	        return map;
	    }
	 @RequestMapping(value ="/deleteEmployeeAjax", method = RequestMethod.POST)
	 public @ResponseBody
     	 Map<String,Object> deleteEmployee(@RequestBody User user) {
		 Map<String,Object> map = new HashMap<>();
		 repo.deleteById(user.getId());
		 return map;
	 }
}
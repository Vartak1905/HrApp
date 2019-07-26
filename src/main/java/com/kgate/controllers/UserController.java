package com.kgate.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kgate.entity.User;
import com.kgate.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository repo;

	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}

	@PostMapping("/authenticate")
	public ModelAndView authenticate(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView();
		User user2 = repo.findUser(user.getEmail(), user.getPassword());
		
		
		if (user2 == null) 
		{
			mav.setViewName("login");
			return mav;
		}
		
		System.out.println(user.getEmail());
		
		mav.setViewName("register");
		return mav;
	}

	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("register");
		repo.save(user);
		return mav;
	}

}

package com.cybage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.model.Book;
import com.cybage.model.User;
import com.cybage.service.BookService;
import com.cybage.service.LoginService;

@Controller
public class LoginController {
	

	@Autowired
	LoginService loginService;
	
	@Autowired
	BookService bookService;
	
	
	
	
	
	@GetMapping("/login")
	public String showForm(Model model) {
		
		model.addAttribute("user", new User());
		
		return "login";
	}
	
	
@PostMapping("/login")
public ModelAndView addBook(@Valid @ModelAttribute("user") User user ,BindingResult result) {
	if(result.hasErrors()) {
		return new ModelAndView("user","user",user);
	}
	
	return new ModelAndView("dispalyBook","bookList",bookService.getBook());
	
}
	
	}


	



package com.projectpet.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.projectpet.model.User;
import com.projectpet.repository.UserRepository;

import com.projectpet.service.UserService;
import com.projectpet.validation.UserValidator;

@Controller
@Scope("request")
@SessionAttributes("sessionownerid")

public class UserController {
		@Autowired
		private User user;
		@Autowired
		private UserService userService;
		@Autowired 
		private UserValidator userValidator; 
		
		
		@RequestMapping(value ="/login", method = RequestMethod.GET)
		   public String init(Model model) {
		    // model.addAttribute("user", new User());
		   return "login";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String submit(@ModelAttribute("user") User user,Model model,HttpSession session) {
		User u=userService.searchUser(user.getUsername(),user.getPassword());
			if(u==null)
			{
				System.out.println("Invalid user");
				model.addAttribute("error", "Invalid Details");					
				return "login";
			}
		 else{ 
			 
				System.out.println("valid user");
				model.addAttribute("msg","Welcome "+u.getUsername());
				session.setAttribute("sessionownerid", u.getId());

				return "home";   
			 }
	    }   
		   
		  @GetMapping("/registration") 
		   public ModelAndView registration(Model model)
		  	{ 
		  		return new ModelAndView("registration","userForm",new User()); 
		    } 
		  
		   @PostMapping("/registration") 
		   public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,Model model) { 
		        userValidator.validate(userForm, bindingResult); 
		        if (bindingResult.hasErrors()) { 
		            return "registration"; 
		        } 
		        userService.save(userForm); 
		        model.addAttribute("user",userForm.getUsername());
		        return "successfullreg";
		        } 
		   
		   @RequestMapping(value ="/find", method = RequestMethod.GET)
		   public void find(Model model,HttpSession session){
			System.out.println(session.getAttribute("sessionownerid"));
			   
		   }
		   }
		  



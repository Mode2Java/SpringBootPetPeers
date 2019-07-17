package com.PetStop.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.PetStop.model.Pet;
import com.PetStop.model.User;
import com.PetStop.repository.PetRepository;
import com.PetStop.repository.UserRepository;

@Controller
@RequestMapping(value="/pet")
public class PetsAppController {
	@Autowired
	PetRepository petRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	DataSource datasource;
	
	 
/* @RequestMapping(value = "/", method = RequestMethod.GET)
	   public ModelAndView login() {
	      return new ModelAndView("login","command",new User());
	   }
	   
	  @RequestMapping(value = "/login", method = RequestMethod.POST)
	      public ModelAndView authenticateUser(@ModelAttribute("user")User user,ModelMap model)
	   { 
		User u =  userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());

		if(u==null)
		//if(result.hasErrors())
		{
			System.out.println("Invalid user");
			return new ModelAndView("login","msg","Invalid user");
		}
		else
		{   System.out.println("valid user");
			return new ModelAndView("homepage","msg","Welcome "+u.getUserName());
		
		}} */
			 
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	   public String init(Model model ) {
	     //model.addAttribute("user",new User());
	     return "login";
	   }

	   @RequestMapping(method = RequestMethod.POST)
	   public String submit(Model model,@ModelAttribute("user") User user) {
		   User u =  userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
		   if(u==null)
				{model.addAttribute("error", "Invalid Details");
				 return "login";
				 }
			else{
				System.out.println("valid user");
				model.addAttribute("msg","Welcome "+user.getUserName());
				return "homepage";
				}
	    		     
	   }
	/*CrudRepository c;
	 PagingAndSortingRepository p;*/
	  
		
	/*@RequestMapping(value = "/create", method = RequestMethod.POST)
	   
	  public void createPet(){
	   //@ResponseBody
	  // public List<Pet> getAllPets1(){
		   User user1 = new User(200,"veena","venaaa");
		   userRepository.save(user1);
		   Set<Pet> petss = new HashSet<Pet>();
		   Pet pp = new Pet(12,"raju",4,"kl");
		   petss.add(pp);
		   pp.setUser(user1);		  
	      petRepository.save(pp);
	      System.out.println("mapped two tables successfully");
	}*/
		@RequestMapping("/home")  
	    public ModelAndView showHome(){  
	         //command is a reserved request attribute name, now use <form> tag to show object data  
	        return new ModelAndView("redirect:/pet/viewallpets","command",new Pet());  
	    }  
		@RequestMapping("/addPet")  
	    public String addPet(Model model){  
	         //command is a reserved request attribute name, now use <form> tag to show object data  
	        model.addAttribute("addPet", new Pet());
			return "addPet";  
			
	    }  
	    
	 
	      @RequestMapping(value = "/viewallpets",method = RequestMethod.GET)
	  	public String index(HttpServletRequest request, ModelMap modelMap) {
	  		List<Pet> pets = (List<Pet>)petRepository.findAll();
	  		PagedListHolder pagedListHolder = new PagedListHolder(pets);
	  		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
	  		pagedListHolder.setPage(page);
	  		pagedListHolder.setPageSize(5);
	  		modelMap.put("pagedListHolder", pagedListHolder);
	  		return "homepage";

	      }
	   /* @RequestMapping(value = "/viewmypets",method = RequestMethod.POST)
		  	public String myPets(HttpServletRequest request, ModelMap modelMap, @ModelAttribute("username") String username) {
	    	User u = userRepository.findUserById(username);
		  		List<Pet> pets = (List<Pet>)petRepository.findAllById(u.getOwnerId());
		  		
		  		PagedListHolder pagedListHolder = new PagedListHolder(pets);
		  		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		  		pagedListHolder.setPage(page);
		  		pagedListHolder.setPageSize(3);
		  		modelMap.put("pagedListHolder", pagedListHolder);
		  		return "viewMyPets";

		      }
		 */
	      
	     @RequestMapping(value="/savePet", method=RequestMethod.POST)
	  	public ModelAndView savePet(@ModelAttribute Pet pet){
	  		System.out.println("Pet Details Requested: All Pets");
	  		petRepository.save(pet);
	  		return new ModelAndView("redirect:/pet/viewallpets","command",new Pet());
	  	}
	   
}

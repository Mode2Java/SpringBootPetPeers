package com.PetStop.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.PetStop.model.Pet;
import com.PetStop.model.User;
import com.PetStop.service.PetService;
import com.PetStop.service.UserService;

@Controller
@RequestMapping(value="/pet")
@Scope("request")
@SessionAttributes("sessionuser")

public class PetsAppController {
	@Autowired
	PetService petService;
	@Autowired
	DataSource datasource;
	
		
	
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
		
		@RequestMapping(value="/advanceSearch", method=RequestMethod.POST)  
	    public String searchPet(@ModelAttribute("pet") Pet pet,HttpServletRequest request,ModelMap modelMap) throws ServletRequestBindingException{  
	        		
			System.out.println("inside advance serarch metthod");
			String petName = request.getParameter("petName");
			
			int petAge=Integer.parseInt(request.getParameter("petAge"));
						
			
			String petPlace = request.getParameter("petPlace");
			//int petAge = ServletRequestUtils.getIntParameter(request, "petAge");
			List<Pet> pt = petService.searchAllByPetNameOrPetAgeOrPetPlace(petName,petAge,petPlace);
			//model.addAttribute("searchList", pt);
			PagedListHolder pagedListHolder = new PagedListHolder(pt);
	  		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
	  		pagedListHolder.setPage(page);
	  		pagedListHolder.setPageSize(5);
	  		modelMap.put("pagedListHolder", pagedListHolder);
			return "searchResult";  
			
	    }  
	      @RequestMapping(value = "/viewallpets",method = RequestMethod.GET)
	  	public String index(HttpServletRequest request, ModelMap modelMap) {
	    	  System.out.println("in home page");
	  		List<Pet> pets = (List<Pet>)petService.searchAll();
	  		PagedListHolder pagedListHolder = new PagedListHolder(pets);
	  		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
	  		pagedListHolder.setPage(page);
	  		pagedListHolder.setPageSize(5);
	  		modelMap.put("pagedListHolder", pagedListHolder);
	  		return "homepage";

	      }
	    @RequestMapping(value = "/viewmypets")
		  	public String myPets(HttpServletRequest request,HttpSession session,ModelMap modelMap) {
	    	System.out.println(session.getAttribute("sessionuser"));
	    	User user = (User) session.getAttribute("sessionuser");
		  	List<Pet> pets= petService.searchAllByUser(user);
		  		PagedListHolder pagedListHolder = new PagedListHolder(pets);
		  		int page = ServletRequestUtils.getIntParameter(request, "p", 0);
		  		pagedListHolder.setPage(page);
		  		pagedListHolder.setPageSize(3);
		  		modelMap.put("pagedListHolder", pagedListHolder);
		  		return "viewMyPets";

		      }
		 
	      
	    @RequestMapping(value="/savePet", method=RequestMethod.POST)
	  	public ModelAndView savePet(@ModelAttribute Pet pet,HttpSession session){
	  		System.out.println("Pet Details Requested: All Pets");
	  		System.out.println(pet);
	  		User user = (User) session.getAttribute("sessionuser");
	    	 	pet.setUser(user);
	    	System.out.println( pet.getUser());
	  		petService.savePet(pet);
	  		return new ModelAndView("redirect:/pet/viewallpets","command",new Pet());
	  	}
	   
}

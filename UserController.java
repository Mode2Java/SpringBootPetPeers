package petstop.UserRegistration.controller;
import petstop.UserRegistration.model.User;
import petstop.UserRegistration.service.UserService;
import petstop.UserRegistration.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
	public class UserController {
	   
		@Autowired
	    private UserService userService;
	    @Autowired
	    private UserValidator userValidator;

	    @GetMapping("/registration")
	    public ModelAndView registration(Model model) {
	    	System.out.println("HHHHHHHHHELLLLLLo");
	        //model.addAttribute("userForm", new User());

	        return new ModelAndView("registration1","userForm",new User());
	    }
	    @PostMapping("/registration")
	    public ModelAndView registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult,ModelMap model) {
	        userValidator.validate(userForm, bindingResult);

	        if (bindingResult.hasErrors()) {
	            return new ModelAndView("registration1");
	        }

	        userService.save(userForm);	       
	        System.out.println("GO TO Succful viewww ");
	        model.addAttribute("name",userForm.getUsername());
	        return new ModelAndView("successfullreg");
	    }

}

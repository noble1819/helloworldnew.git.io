package Servion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("update")
public class UpdateController {

	HiberOperations db=new HiberOperations();
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView updatepasswordpage(UserBean ubean)
	{
		System.out.println("get");
		ModelAndView mdl=new ModelAndView();
		mdl.addObject("userbean",ubean);
		mdl.setViewName("UpdatePassword");
		return mdl;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView updatepassword(UserBean ubean)
	{
		System.out.println("post");
		ModelAndView mdl=new ModelAndView();
		db.changepassword(ubean.getUsername().trim(),ubean.getPassword().trim());
		mdl.addObject("userbean",ubean);
		mdl.setViewName("welcome");
		return mdl;
	}
}

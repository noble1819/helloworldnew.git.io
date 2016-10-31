package Servion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("register")
public class RegisterController {

	HiberOperations db=new HiberOperations();
	
	@Autowired
	UserBean userbean;
	
	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView RegisterAction(UserBean userbean)
	{
		ModelAndView mdl=new ModelAndView();
		
		if(db.checkuser(userbean.getUsername().toString().trim()))
		{
			mdl.setViewName("login");
		}
		else
		{
			db.InsertDatabase(userbean.getFname(),userbean.getLname(),userbean.getUsername(),userbean.getPassword(),0);
			mdl.setViewName("login");
		}
		
		mdl.addObject("userbean",userbean);
		
		return mdl;
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView RegisterActionDemo()
	{
		ModelAndView mdl=new ModelAndView();
		
		mdl.addObject("userbean",userbean);
		
		return mdl;
		
	}
	
	
	
	
}

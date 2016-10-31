package Servion;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("logout")
public class LogoutController {

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
	public ModelAndView logoutAction(HttpSession session)
	{
		LangClass lang=new LangClass();
		String uname=session.getAttribute("username").toString().trim();
		ModelAndView mdl=new ModelAndView();
		db.changestatus(uname, 0);
		session.invalidate();
		mdl.setViewName("index");
		mdl.addObject("lang",lang);
		return mdl;
	}
	
	
}

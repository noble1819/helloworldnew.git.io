package Servion;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {
	
	HiberOperations db=new HiberOperations();
	
	@Autowired
	UserBean userBean;
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getmethod()
	{
		UserBean userbean=new UserBean();
		ModelAndView mdlvie=new ModelAndView();
		mdlvie.setViewName("login");
		mdlvie.addObject("userbean",userbean);
		
		return mdlvie;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView userbeandemo(UserBean bean,HttpSession session)
	{
		
		ModelAndView mdlvie=new ModelAndView();

		if(db.checkuser(bean.getUsername().toString().trim()))
		{
				if(db.checkUserAndPassword(bean.getUsername().toString().trim(),bean.getPassword().toString().trim()))
				{
					db.changestatus(bean.getUsername().toString().trim(),1);
					mdlvie.setViewName("home");
					session.setAttribute("username",bean.getUsername());
				}
				else
				{
					mdlvie.setViewName("account");
				}
		}
		else
		{
			mdlvie.setViewName("account");
		}
		
		
		
		mdlvie.addObject("userbean",bean);
		return mdlvie;
		
	}
	

}

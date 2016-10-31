package Servion;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lang")
public class LangController {

	@Autowired
	UserBean userbean;
	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}
	@Autowired
	LangClass lang;
	
	public LangClass getLang() {
		return lang;
	}


	public void setLang(LangClass lang) {
		this.lang = lang;
	}
	
	


	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getmethod()
	{
		
		ModelAndView mdlvie=new ModelAndView();
		mdlvie.setViewName("home");
		//mdlvie.addObject("lang",lang);
		return mdlvie;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView langmethod(LangClass lang,HttpSession session)
	{
		
		ModelAndView mdlvie=new ModelAndView();
		//ResourceBundle rb=ResourceBundle.getBundle("dictionary",new Locale(lang.getLang()));
		//session.setAttribute("languageselection",rb);
		mdlvie.setViewName("login");
		mdlvie.addObject("userbean",userbean);
		return mdlvie;
	}
	
	

}

package Servion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("additem")
public class AddItem 
{
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView RequestPost(ItemBean iBean)
	{ModelAndView mdlvie=new ModelAndView();
		addCartItem(iBean);
		System.out.println(iBean.getId());
		mdlvie.setViewName("home");
		return mdlvie;
	}
	private void addCartItem(ItemBean iBean)
	{
		CartItems.getInstance().addItem(iBean);
	}
}

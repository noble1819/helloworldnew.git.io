package Servion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("delivery")
public class Delivery 
{
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView RequestGet()
	{
		emptyCart();
		return new ModelAndView("redirect:index");
	}
	private void emptyCart()
	{
		CartItems.getInstance().remove();
	}
}

package Servion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("cart")
public class Mycart 
{
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView RequestGet()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("cartList",CartItems.getList());
		mv.setViewName("checkout");
		mv.addObject("iBean",new ProductDescBean());
		mv.addObject("total",CartItems.TotalPrice());
		mv.addObject("tax",CartItems.Tax());
		mv.addObject("bill",CartItems.Bill());
		
		return mv;
	}
	
	
}

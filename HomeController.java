package Servion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("home")
public class HomeController {

	@Autowired
	UserBean userbean;
	
	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}
	
	@Autowired
	ProductBean pbean;

	public ProductBean getPbean() {
		return pbean;
	}

	public void setPbean(ProductBean pbean) {
		this.pbean = pbean;
	}
	

	
	

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView moveShoppingPage()
	{
		Session session=SessionUtility.GetSessionConnection();
		
		String hql = "FROM ProductDescBean order by rand()";
		
		Query query = session.createQuery(hql);
		
		query.setMaxResults(5);
				@SuppressWarnings("unchecked")
		List<ProductDescBean> results = query.list();
				
				
		ModelAndView mdl=new ModelAndView();
		ProductBean pbean=new ProductBean();
		
		mdl.setViewName("home");
		mdl.addObject("pbean",pbean);
		mdl.addObject("iBean",new ItemBean());
		mdl.addObject("product",results);
		
		return mdl;
	}
	
}
	
	

	

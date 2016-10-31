package Servion;

import java.util.Enumeration;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import Servion.HiberOperations;

@SuppressWarnings("serial")
public class InvoiceClass extends TagSupport{

	Enumeration<String> e;
	@Override
	public int doEndTag() throws JspException {
		
		HiberOperations h=new HiberOperations();
		e=pageContext.getSession().getAttributeNames();
		
		JspWriter out=pageContext.getOut();
	
		while(e.hasMoreElements())
		 {
			
			 String pa=e.nextElement().toString();
			if(pa.equalsIgnoreCase("languageselection") || pa.equalsIgnoreCase("username")){
				
			}
			else{
			 
			 String value=pageContext.getSession().getAttribute(pa).toString();
			 String url=h.GetproductImage(value.trim());
			 String tex=h.GetproductDes(value.trim());
			 try{
				 
				 	out.println("<div class='container w3'>");	
					out.println("<div class='uk-panel uk-panel-box uk-text-center'>");
					out.println("<img class= width='20' height='20' src='"+url+"' alt=''>");
					out.println("<h3>"+value+"</h3>");
					out.println("<h3>"+tex+"</h3>");
					out.println("</div>");
					out.println("</div>");
			 
			 }catch(Exception e){}
			}
		 }
		
		
		return super.doEndTag();
	}
	
}

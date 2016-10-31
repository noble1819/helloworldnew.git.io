package Servion;

import org.springframework.stereotype.Component;


@Component
public class ProductBean {

	private String[] product;
	private String page;
	
	
	
	public String[] getProduct() {
		return product;
	}
	public void setProduct(String[] product) {
		this.product = product;
	}
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	
	
}

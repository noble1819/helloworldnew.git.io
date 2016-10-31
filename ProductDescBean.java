package Servion;

import org.springframework.stereotype.Component;

@Component
public class ProductDescBean {
	private int pid;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	private String p_name;
	private int p_price;
	private String p_cat;
	private String p_desc;
	private String p_img;
	
	public String getP_img() {
		return p_img;
	}
	public void setP_img(String p_img) {
		this.p_img = p_img;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getP_cat() {
		return p_cat;
	}
	public void setP_cat(String p_cat) {
		this.p_cat = p_cat;
	}
	public String getP_desc() {
		return p_desc;
	}
	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}
	
	

}

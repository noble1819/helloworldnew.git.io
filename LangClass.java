package Servion;

import org.springframework.stereotype.Component;

@Component
public class LangClass {
	
	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}

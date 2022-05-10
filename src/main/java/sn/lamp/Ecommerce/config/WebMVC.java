package sn.lamp.Ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebMVC  extends  WebMvcConfigurerAdapter{
	public void addViewController(ViewControllerRegistry registry) {
		registry.addViewController("logout").setViewName("login");
		registry.addViewController("login").setViewName("login");
	}

}

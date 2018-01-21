package pl.coderslab.apiBack.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "pl.coderslab.apiBack.model", "pl.coderslab.apiBack.controller" })
public class AppConfig extends WebMvcConfigurerAdapter {
	
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
//		allowedOrigins("http://localhost");
	}
}

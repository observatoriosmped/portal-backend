package br.gov.sp.prefeitura.smped.portalObservatorio.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConfigurationProperties(prefix = "app.cors")
public class CorsConfig {
	
	private List<String> allowedOrigins;

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
            		.allowedOrigins(getAllowedOrigins().toArray(new String[0]))
					.allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
					.exposedHeaders("Set-Cookie")
					.allowCredentials(true);
            }
        };
    }
	
	public List<String> getAllowedOrigins() {
		return allowedOrigins;
	}

	public void setAllowedOrigins(List<String> allowedOrigins) {
		this.allowedOrigins = allowedOrigins;
	}

}

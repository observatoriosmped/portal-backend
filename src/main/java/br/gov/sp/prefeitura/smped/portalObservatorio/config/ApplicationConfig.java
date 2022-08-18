package br.gov.sp.prefeitura.smped.portalObservatorio.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="app")
public class ApplicationConfig {

	@NotNull private String apiPainelBaseUrl;

	public String getApiPainelBaseUrl() {
		return apiPainelBaseUrl;
	}

	public void setApiPainelBaseUrl(String apiPainelBaseUrl) {
		this.apiPainelBaseUrl = apiPainelBaseUrl;
	}
	
	
}

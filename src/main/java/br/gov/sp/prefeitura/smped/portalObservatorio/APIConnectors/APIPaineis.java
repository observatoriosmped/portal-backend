package br.gov.sp.prefeitura.smped.portalObservatorio.APIConnectors;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.UnAuthenticatedServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import br.gov.sp.prefeitura.smped.portalObservatorio.config.ApplicationConfig;
import br.gov.sp.prefeitura.smped.portalObservatorio.domain.Painel;
import reactor.core.publisher.Mono;

@Service
public class APIPaineis {

	private String baseUrl;

	@Autowired
	@Qualifier("authProvider")
	private WebClient painelClient;

	@Bean("authProvider")
	WebClient authProviderWebClient(ApplicationConfig config,
			ReactiveClientRegistrationRepository clientRegistrations) {

		this.baseUrl = config.getApiPainelBaseUrl();

		ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
				.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(1024 * 10000)).build();

		ServerOAuth2AuthorizedClientExchangeFilterFunction oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(
				clientRegistrations, new UnAuthenticatedServerOAuth2AuthorizedClientRepository());
		oauth.setDefaultClientRegistrationId("authProvider");

		return WebClient
				.builder()
				.filter(oauth)
				.baseUrl(baseUrl)
				.exchangeStrategies(exchangeStrategies)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_STREAM_JSON_VALUE)
				.build();
	}

	@Bean
	ReactiveClientRegistrationRepository getRegistration(
			@Value("${security.oauth2.client.provider.authProvider.token-uri}") String tokenUri,
			@Value("${security.oauth2.client.registration.authProvider.client-id}") String clientId,
			@Value("${security.oauth2.client.registration.authProvider.client-secret}") String clientSecret,
			@Value("${security.oauth2.client.registration.authProvider.scopes}") List<String> scope
			) {
		ClientRegistration registration = ClientRegistration
				.withRegistrationId("authProvider")
				.tokenUri(tokenUri)
				.clientId(clientId)
				.clientSecret(clientSecret)
				.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
				.scope(scope)
				.build();
		return new InMemoryReactiveClientRegistrationRepository(registration);
	}

	public List<Painel> getPaineis() {

		Mono<Painel[]> result = painelClient.method(HttpMethod.GET).uri("/paineis").retrieve()
				.bodyToMono(Painel[].class);
		List<Painel> paineis = Arrays.asList(result.block());

		return paineis;
	}

	public Painel getPainel(String painelId) {

		Mono<Painel> result = painelClient.method(HttpMethod.GET).uri("/paineis/" + painelId).retrieve()
				.bodyToMono(Painel.class);
		Painel painel = result.block();

		return painel;
	}

}

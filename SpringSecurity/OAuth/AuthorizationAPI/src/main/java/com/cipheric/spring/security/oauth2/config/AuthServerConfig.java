package com.cipheric.spring.security.oauth2.config;

import java.security.KeyPair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import com.cipheric.spring.security.oauth2.service.MyUserDetailsService;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Value("${jkspath}")
	private String jkspath;

	@Value("${alias}")
	private String alias;

	@Value("${password}")
	private String password;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore())
		.accessTokenConverter(jwtAccessTokenConverter())
		.authenticationManager(authenticationManager)
		.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("sampleClient").resourceIds("CL_2021-1").secret(passwordEncoder.encode("12345"))
			//.authorizedGrantTypes("password", "refresh_token")
			.authorizedGrantTypes("authorization_code")
			.scopes("read", "write");
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()");
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
			JwtAccessTokenConverter jwtAccessTokenConverter =  new JwtAccessTokenConverter();
			KeyStoreKeyFactory  ksFactory = new KeyStoreKeyFactory(new ClassPathResource(jkspath), password.toCharArray());
			KeyPair kp = ksFactory.getKeyPair(alias);
			jwtAccessTokenConverter.setKeyPair(kp);
			return jwtAccessTokenConverter;
		}
}

package com.gohul.Oath2Client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Value("${github.client-id}")
    private String clientId;

    @Value("${github.client-secret}")
    private String clientSecret;

    @Bean
    public SecurityFilterChain mySecurityConfig(HttpSecurity http) throws  Exception{

        http.authorizeHttpRequests(req -> {
            req.requestMatchers("securePage").authenticated();
            req.anyRequest().permitAll();
        });
        http.formLogin(Customizer.withDefaults());
        http.oauth2Login(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public ClientRegistrationRepository clientRegRepo()
    {
        ClientRegistration gitHub = getGitHubRegistration();
        return new InMemoryClientRegistrationRepository(gitHub);
    }

    private ClientRegistration getGitHubRegistration()
    {
        return CommonOAuth2Provider.GITHUB.getBuilder("gitHub")
                .clientId(clientId)
                .clientSecret(clientSecret).build();
    }
}


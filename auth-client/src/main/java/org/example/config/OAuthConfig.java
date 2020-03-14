package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import java.util.Arrays;


@Configuration
@EnableOAuth2Sso
public class OAuthConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2ClientContextFilter oauth2ClientContextFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/","/login**")
                .permitAll()
                .anyRequest()
                .authenticated()
        .and().addFilterAfter(oauth2ClientContextFilter, SecurityContextPersistenceFilter.class);

    }

    @Bean
    public OAuth2ProtectedResourceDetails resourceDetails() {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        resource.setClientId("ClientId");
        resource.setClientSecret("secret");
        resource.setAccessTokenUri("http://localhost:8981/auth/oauth/token");
        resource.setUserAuthorizationUri("http://localhost:8981/auth/oauth/authorize");
        return resource;
    }


}

package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import javax.annotation.Resource;

@Configuration
@EnableOAuth2Client
public class Oauth2Client {

    @Resource
    private OAuth2ClientContext oAuth2ClientContext;

    @Bean
    public OAuth2ProtectedResourceDetails resourceDetails() {
        AuthorizationCodeResourceDetails resource = new AuthorizationCodeResourceDetails();
        resource.setClientId("ClientId");
        resource.setClientSecret("secret");
        resource.setAccessTokenUri("http://localhost:8981/auth/oauth/token");
        resource.setUserAuthorizationUri("http://localhost:8981/auth/oauth/authorize");

        return resource;
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    public OAuth2RestOperations  oAuth2RestTemplate() {
        return new OAuth2RestTemplate(resourceDetails(),oAuth2ClientContext);
    }
}

//package org.example.controller;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private OAuth2RestTemplate redditRestTemplate;
//
//    @GetMapping("/ui/login")
//    public String login() {
//        JsonNode node = redditRestTemplate.getForObject(
//                "http://localhost:8981/auth/rest/user", JsonNode.class);
//        UsernamePasswordAuthenticationToken auth =
//                new UsernamePasswordAuthenticationToken(node.get("name").asText(),
//                        redditRestTemplate.getAccessToken().getValue(),
//                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
//
//        SecurityContextHolder.getContext().setAuthentication(auth);
//        return "index";
//    }
//}

package org.ibs.service.confing;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

//@KeycloakConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
//    @Override
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new NullAuthenticatedSessionStrategy();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authManagerBuilder) {
//        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//        authManagerBuilder.authenticationProvider(keycloakAuthenticationProvider);
//    }
//
//    @Bean
//    public KeycloakConfigResolver keycloakConfigResolver() {
//        return new KeycloakSpringBootConfigResolver();
//    }
//
//    @Bean
//    protected void configure(HttpSecurity http) throws Exception {
//
//        String indexURL = "http://localhost:8443/swagger-ui/index.html?urls.primaryName=v2#/";
//
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .requestMatchers("/**").hasRole("READER")
//                .requestMatchers(HttpMethod.DELETE, "/v2/employees").hasRole("WRITER")
//                .requestMatchers(HttpMethod.POST, "/v2/employees").hasRole("WRITER")
//                .and()
//                .formLogin()
//                .defaultSuccessUrl(indexURL,true);
//    }
//
////    @Override
////    public void init(WebSecurity builder) throws Exception {
////
////    }
////
////    @Override
////    public void configure(WebSecurity builder) throws Exception {
////
////    }
//}

package com.casestudy.webapp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests((authorize) -> authorize
                        // Require authentication for /customer/** endpoints
//                .requestMatchers("/customer/**").authenticated()
//                .requestMatchers("/employee/**").authenticated()

                        // Allow all other requests without authentication
                        .anyRequest().permitAll()
        );

        http.formLogin(formLogin -> formLogin
                // this is the URL for the login page ... this needs a controller method to listen and show the login page
                // this is alnalagous to /customer and the page is login
                .loginPage("/login/login")
                // spring security has this controller method created for us already .. and we are just configuring the URL where it submits to
                .loginProcessingUrl("/login/loginSubmit"));

        // this section is for configuing logout
        http.logout(formLogout -> formLogout
                // when the user logs out ... destroy the session the server side
                .invalidateHttpSession(true)
                // this is the acutal URL this is implemented by spring security and we are just specifying the get mapping for it
                .logoutUrl("/login/logout")
                // where does the user go after they have been logged out
                // this is a URL that we have implemented somewhere in our project or controllers
                .logoutSuccessUrl("/logoutSuccess")
                // extra security and delete these cookies when logging out
                .deleteCookies("username", "JSESSIONID"));

        // only if the user goes to a page that they do not have authorization for then it goes to this page
        // instead of showing a whitelabel error page
        http.exceptionHandling(exception -> exception
                .accessDeniedPage("/404"));

        return http.build();

    }
    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }


    }


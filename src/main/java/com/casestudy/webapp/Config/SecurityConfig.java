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

        // Disables (CSRF) protection.
        http.csrf(csrf -> csrf.disable());

        //Allow all incoming HTTP requests without authentication.
        http.authorizeHttpRequests((authorize) -> authorize

                .anyRequest().permitAll()
        );

        //Enable authentication
        http.formLogin(formLogin -> formLogin

                .loginPage("/login/login")

                .loginProcessingUrl("/login/loginSubmit"));


        // Logout configuration
        http.logout(formLogout -> formLogout

                .invalidateHttpSession(true)

                .logoutUrl("/login/logout")

                .logoutSuccessUrl("/logoutSuccess")
                // Delete cookies when logging out
                .deleteCookies("username", "JSESSIONID"));


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


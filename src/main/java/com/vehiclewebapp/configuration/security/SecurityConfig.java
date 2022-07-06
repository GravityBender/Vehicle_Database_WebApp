package com.vehiclewebapp.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private DataSource securityDataSource;

    // For quick testing
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(){
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        UserDetails user1 = users.username("John")
//                .password("password1")
//                .roles("Admin")
//                .build();
//
//        UserDetails user2 = users.username("Susan")
//                .password("password2")
//                .roles("Admin")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }


    @Bean
    public UserDetailsManager users(){
        return new JdbcUserDetailsManager(securityDataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeRequests()

//                .antMatchers("").permitAll().anyRequest().permitAll()
//                .antMatchers("/css/**").permitAll().anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/loginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .defaultSuccessUrl("/list", true)
                    .permitAll()
                .and()
                .logout().permitAll();

        return http.build();
    }
}

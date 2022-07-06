package com.vehiclewebapp.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        UserDetails user1 = users.username("John")
                .password("password1")
                .roles("Admin")
                .build();

        UserDetails user2 = users.username("Susan")
                .password("password2")
                .roles("Admin")
                .build();


        return new InMemoryUserDetailsManager(user1, user2);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/css/**").permitAll()
//                .antMatchers("/loginPage").authenticated()
//                .and()
//                .formLogin()
//                    .loginPage("/loginPage")
//                    .loginProcessingUrl("/authenticateTheUser")
//                    .permitAll()
//                .and()
//                .logout()
//                    .logoutSuccessUrl("/")
//                    .permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/access-denied");

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

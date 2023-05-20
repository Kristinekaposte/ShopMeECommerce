package com.shopMeECommerce.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
 // @EnableWebSecurity
public class WebSecurityConfigAdmin { // extends WebSecurityConfiguration
    @Bean
    public PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().anyRequest().permitAll(); //  can access homepage with no login
        http.authorizeHttpRequests()
                .anyRequest().authenticated() // to access app we need to login
                .and()
                .formLogin()
                .loginPage("/homeAdmin/login")
                .usernameParameter("email")
                .permitAll();


        return http.build();
    }

//    @Bean
//    public void configure (WebSecurity web) throws Exception {
//       web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
//}

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    }
}

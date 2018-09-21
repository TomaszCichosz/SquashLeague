package com.groupproject.configuration;

import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserFacade userFacade;

    @Autowired
    public SecurityConfig(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/api.**").permitAll()
                .antMatchers("/home.html").permitAll()
                .anyRequest().permitAll()
                .and()
                .headers().frameOptions().disable()
                .and()
                .cors().disable();

        http.formLogin()
                .loginPage("/index")
                .failureHandler((req, resp, e) -> resp.sendError(HttpStatus.BAD_REQUEST.value(), "Invalid username or password"))
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/users/home")
                .permitAll();

        http.logout()
                .logoutUrl("users/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/index")
                .permitAll();

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return userFacade.getUserDetailsServiceImpl();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}

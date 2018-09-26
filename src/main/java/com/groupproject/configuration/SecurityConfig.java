package com.groupproject.configuration;

import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
                .antMatchers("/index", "/").permitAll()
                .antMatchers("/users/adduser").permitAll()
                .antMatchers("/passwords/reset/view").permitAll()
                .antMatchers("/users/index").permitAll()
                .antMatchers("index.html","adduser.html","reset-view.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable()
                .and()
                .cors().disable();

        http.formLogin()
                .loginPage("/index").permitAll()
                .failureHandler((req, resp, e) -> resp.sendRedirect("/index/error")).permitAll()
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

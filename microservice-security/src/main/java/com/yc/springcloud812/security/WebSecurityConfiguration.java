package com.yc.springcloud812.security;

import com.yc.springcloud812.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity   //  启用安全
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder()).withUser("root")
//                .password(new BCryptPasswordEncoder().encode("a"))
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password(new BCryptPasswordEncoder().encode("a"))
//                .roles("USER", "ADMIN");
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                //.anyRequest().fullyAuthenticated()
                .antMatchers("/book/?").hasAnyRole("USER","ADMIN")
               .antMatchers("/book/findAll").hasRole("ADMIN");

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests()
//                .antMatchers("/book/?").hasAnyRole("USER","ADMIN")
//                .antMatchers("/book/findAll").hasRole("ADMI·N")
//                .and().formLogin().usernameParameter("username")
//                .passwordParameter("password");
//        http.formLogin()
//                .and().authorizeRequests()
//                .antMatchers("/book/?").hasAnyRole("USER","ADMIN")
//                .antMatchers("/book/findAll").hasRole("ADMIN");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/actuator/hystrix.stream","/turbine.stream") ;
    }
}

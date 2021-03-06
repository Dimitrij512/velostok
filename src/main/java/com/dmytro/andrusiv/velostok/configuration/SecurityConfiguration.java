package com.dmytro.andrusiv.velostok.configuration;

import com.dmytro.andrusiv.velostok.configuration.securityFilters.JWTAuthenticationFilter;
import com.dmytro.andrusiv.velostok.configuration.securityFilters.JWTAuthorizationFilter;
import com.dmytro.andrusiv.velostok.services.impl.userDetail.UserDtlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.dmytro.andrusiv.velostok.configuration.securityFilters.SecurityConstants.SIGN_UP_URL;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String ANTPATTERNOPTIONS = "/**";
    private static final String ANTPATTERNDELETE = "/admin/user/**";
    private static final String[] ANTPATTERNCLIENTPOST = {"/admin/user","/admin/user/**","/testUser","/testUser/**"};
    private static final String[] ANTPATTERNGET = {"/allSuperCategories","/allCategories",
            "/allSubCategories","/superCategory/**","/category/**","/subCategory/**",
            "/allProducts","/product/**","/products/category/**","/subCategory/**",
            "/category/superCategory/**","/admin/user/**"};

    @Autowired
    private UserDtlsService dtlsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(dtlsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .anyRequest().authenticated().and().addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager())).sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) {

        web.ignoring().antMatchers(HttpMethod.OPTIONS, ANTPATTERNOPTIONS);
        web.ignoring().antMatchers(HttpMethod.POST, ANTPATTERNCLIENTPOST);
        web.ignoring().antMatchers(HttpMethod.GET, ANTPATTERNGET);
        web.ignoring().antMatchers(HttpMethod.DELETE, ANTPATTERNDELETE);
    }

}
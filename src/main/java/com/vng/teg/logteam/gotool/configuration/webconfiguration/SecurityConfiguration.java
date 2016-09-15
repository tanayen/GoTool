package com.vng.teg.logteam.gotool.configuration.webconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    @Qualifier("myUserDetailsService")
//    private UserDetailsService userService;

//    @Bean(name = "passwordEncoder")
//    public Md5PasswordEncoder passwordEncoder() {
//        return new Md5PasswordEncoder();
//    }

//    @Autowired
//    private Md5PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // UTF-8 Encoding
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        http.addFilterBefore(characterEncodingFilter, CsrfFilter.class);

        http.authorizeRequests()
                .antMatchers("/**").permitAll();
//                .antMatchers("/login", "/resources/**").permitAll()
//                .antMatchers("/intern/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPERVISOR')")
//                .antMatchers("/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_INTERN') or hasRole('ROLE_SUPERVISOR')")
//                .and().formLogin().loginPage("/login")
//                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}

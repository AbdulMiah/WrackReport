package cf.ac.uk.wrackreport.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    //Configure which pages require logging in
     @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint());
        //Configure which pages require logging in
        http
//                .csrf().disable()
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .mvcMatchers("/report-info").authenticated()
                                .antMatchers("/js/**", "/css/**").permitAll()
                                .mvcMatchers("/test-data/**").permitAll()
                                .mvcMatchers("/images/**").permitAll()
                                .mvcMatchers("/api/report-info").authenticated()
                                .mvcMatchers("/").permitAll()
                                .mvcMatchers("/privacy-policy").permitAll()
                                .mvcMatchers("/api/reports").permitAll()
                                .mvcMatchers("/api/report/{furl}").permitAll()
                                .mvcMatchers("/report-form").permitAll()
                                .mvcMatchers("/ReportSubmitted").permitAll()
                                .mvcMatchers("/reports-overview").authenticated()
                                .mvcMatchers("/detailed-report/{furl}").permitAll()
                                .mvcMatchers("/api/**").permitAll()
                                .mvcMatchers("/category/**").permitAll()
                                .anyRequest().denyAll()
                
        )

                .formLogin(formLogin ->
                        formLogin
                                .permitAll()
                                .defaultSuccessUrl("/reports-overview", true)
                ).logout(logout ->
                        logout
                                .permitAll());
    }


    //Create Authentication Manager Builder to configure authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

    //Create BCrypt Password Encoder
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

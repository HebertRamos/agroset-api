package br.com.app.agrosetapi.seguranca.config;

import br.com.app.agrosetapi.seguranca.handler.DefaultAuthenticationFailureHandler;
import br.com.app.agrosetapi.seguranca.handler.DefaultAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author Hramos
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/auth/isLogged").permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin().loginProcessingUrl("/auth/j_spring_security_check")
                .successHandler(new DefaultAuthenticationSuccessHandler())
                .failureHandler(new DefaultAuthenticationFailureHandler())
                .and().logout().logoutUrl("/logout").permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().csrf().disable();


        http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> response.setStatus(HttpServletResponse.SC_UNAUTHORIZED));

    }
}

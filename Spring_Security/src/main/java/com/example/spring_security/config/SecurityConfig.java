package com.example.spring_security.config;

import com.example.spring_security.jwt.JwtConfig;
import com.example.spring_security.jwt.JwtTokenVerifier;
import com.example.spring_security.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.example.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //when use from @preAuthorize above on method
public class SecurityConfig {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenVerifier jwtTokenVerifier;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public SecurityConfig(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository, JwtTokenVerifier jwtTokenVerifier, JwtConfig jwtConfig, SecretKey secretKey) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtTokenVerifier = jwtTokenVerifier;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    /**
     * @return HttpSecurity
     * @implNote this impels for form login or basic authentication
     *
     * @Bean //for from login or basic authentication
     * public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     * String HASH_KEY = "c3c7ff7b25a79cd651f7af450f105a4d291d9b8b5242d6615e9b819bacc0695a";
     * http
     * .cors().and().csrf().disable().anonymous().principal("guest").authorities("Guest").and()
     * //.authorizeRequests().antMatchers("/resources/**").permitAll() //if use security have to permit this folder
     * //.antMatchers(HttpMethod.PUT, "/api/v1/user/**").hasAuthority(PermissionEnum.USER_WRITE.getPermission()) *comment this
     * //.antMatchers(HttpMethod.GET, "/api/v1/user/**").hasAuthority(PermissionEnum.USER_READ.getPermission())  and use from @PreAuthorize
     * //.antMatchers(HttpMethod.POST, "/api/v1/user/**").permitAll()
     * .authorizeRequests().anyRequest()
     * .permitAll()
     * .and()
     * //.httpBasic(); //for basic authentication
     * <p>
     * .formLogin().loginPage("/login").defaultSuccessUrl("/successLogin", true) //for from login authentication
     * .passwordParameter("password") //as default ths same as form in login page
     * .usernameParameter("username") //as default
     * .and().rememberMe() //default is two week!
     * .rememberMeParameter("remember-me") //as default
     * .tokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(7)).key(HASH_KEY) //custom time remember me token
     * .and()
     * .logout()
     * .logoutUrl("/logout")
     * .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) //if csrf is enabled, don't need to this line
     * .clearAuthentication(true)
     * .invalidateHttpSession(true)
     * .deleteCookies("JSESSIONID", "remember-me")
     * .logoutSuccessUrl("/login");
     * <p>
     * return http.build();
     * }
     */

    // for jwt authentication
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(http.getSharedObject(AuthenticationConfiguration.class)), jwtConfig, secretKey))
                .addFilterAfter(jwtTokenVerifier, JwtUsernameAndPasswordAuthenticationFilter.class)
                .anonymous().principal("guest").authorities("Guest").and()
                .authorizeRequests().anyRequest()
                .permitAll();

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService((username) -> userRepository
                        .findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException(String.format("This %s notFound!", username))))
                .passwordEncoder(passwordEncoder);
    }
}

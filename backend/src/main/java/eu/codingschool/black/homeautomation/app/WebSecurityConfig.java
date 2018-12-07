package eu.codingschool.black.homeautomation.app;

import eu.codingschool.black.homeautomation.services.MyUserDetailsService;
import eu.codingschool.black.homeautomation.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@ComponentScan("eu.codingschool.black.homeautomation.app")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  PersonService userService;

  @Bean
  public DaoAuthenticationProvider customAuthenticationProvider(){
    DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    auth.setUserDetailsService(userService);
    auth.setPasswordEncoder(passwordEncoder ());
    return auth;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider (customAuthenticationProvider ());
//    auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
////      .withUser("user")
////      .password("password")
////      .roles("USER")
////    .and()
////      .withUser("admin")
////      .password("password")
////  //              .credentialsExpired(true)
////  //              .accountExpired(true)
////  //              .accountLocked(true)
////  //              .authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES")
////      .roles("ADMIN");

  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder ();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
          .antMatchers ("/login").permitAll ()
          .antMatchers (HttpMethod.OPTIONS, "/**").permitAll ()
          .anyRequest().authenticated()
        .and()
          .httpBasic();
  }
}

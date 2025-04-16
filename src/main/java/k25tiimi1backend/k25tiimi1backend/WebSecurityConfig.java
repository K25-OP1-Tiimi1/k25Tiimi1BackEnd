package k25tiimi1backend.k25tiimi1backend;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
       // return http.authorizeHttpRequests((auth) -> auth.anyRequest().permitAll()).build();
        
          http
          .authorizeHttpRequests(authorize -> authorize
          .requestMatchers(antMatcher("/products")).permitAll()
          .requestMatchers(antMatcher("/users")).permitAll()
          .anyRequest().authenticated())
          .formLogin(formlogin -> formlogin
          .defaultSuccessUrl("/", true)
          .permitAll())
          .logout(logout -> logout
          .permitAll());
          return http.build();
         
    }
    
      @Bean
      public UserDetailsService userDetailsService() {
      List<UserDetails> users = new ArrayList<UserDetails>();
      UserDetails user = User.withDefaultPasswordEncoder()
      .username("admin")
      .password("password")
      .roles("ADMIN")
      .build();
      
      users.add(user);
      
      return new InMemoryUserDetailsManager(users);
      }
     
}

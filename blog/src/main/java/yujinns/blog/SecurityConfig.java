package yujinns.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import yujinns.blog.DTO.User;
import yujinns.blog.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final UserService userService;
//
//    @Autowired
//    public SecurityConfig(UserService userService) {
//        this.userService = userService;
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
                .formLogin().loginPage("/templates/login").usernameParameter("id").passwordParameter("password")
                .defaultSuccessUrl("/templates/home").permitAll()
                .and()
                .logout().logoutUrl("/templates/logout").logoutSuccessUrl("/templates/home").permitAll();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/signup","login").permitAll()
//                .antMatchers("/update").authenticated()
//                .and()
//                .formLogin().loginPage("/login").defaultSuccessUrl("/home").permitAll()
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/home").permitAll();
//    }

/*    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and()
                .formLogin().loginPage("/loginPage").defaultSuccessUrl("/home").permitAll().and()
                .logout().invalidateHttpSession(true).clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll();
    }*/

}

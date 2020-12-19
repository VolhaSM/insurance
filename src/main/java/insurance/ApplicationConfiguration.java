package insurance;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
//@EnableWebSecurity
public class ApplicationConfiguration   {

    //extends WebSecurityConfigurerAdapter
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}password")
//                .roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and()
//                .authorizeRequests().antMatchers("/**").hasRole("USER")
//                .and().formLogin().disable()
//                .csrf().disable();
//    }

    public static void main(String[] args) {

        SpringApplication.run(ApplicationConfiguration.class);
    }
}

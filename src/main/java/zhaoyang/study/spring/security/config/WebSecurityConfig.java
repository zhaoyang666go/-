package zhaoyang.study.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import zhaoyang.study.spring.security.utils.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置内存中的 用户名、角色和密码
        auth.inMemoryAuthentication().passwordEncoder(new PasswordEncoder()).withUser(
                "user").password("123456").roles("USER");
        auth.inMemoryAuthentication().passwordEncoder(new PasswordEncoder()).withUser(
                "admin").password("123456").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/user").hasRole("USER")   //user接口需要USER角色
                .antMatchers("/admin").hasRole("ADMIN") //admin接口需要ADMIN角色
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/hello");
    }
}

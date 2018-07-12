package servertest.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailHandler;
    @Autowired
    private MySessionInformationExpiredStrategy mySessionInformationExpiredStrategy;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .formLogin().loginPage("http://localhost:3000/login").loginProcessingUrl("/api/login")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailHandler)
                .permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
                .and()
                .authorizeRequests()
                .antMatchers("/api/testuploadimg").permitAll() //这就表示这个页面不需要权限认证，所有人都可以访问
                .and()
                .authorizeRequests()
                .antMatchers("/api/getAllMenu").permitAll() //这就表示这个页面不需要权限认证，所有人都可以访问
                .and()
                .authorizeRequests()
                .anyRequest().access("@rbacService.hasPermission(request,authentication)")    //必须经过认证以后才能访问
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and()
                .csrf().disable();
        http.sessionManagement().
                /**
                 * 同一个账号只能在一个地方登陆
                 */
                        maximumSessions(1).
                /**
                 * 自定义session过期策略，替代默认的{@link ConcurrentSessionFilter.ResponseBodySessionInformationExpiredStrategy}，
                 * 复写onExpiredSessionDetected方法，默认方法只输出异常，没业务逻辑。这里需要返回json
                 */
                        expiredSessionStrategy(mySessionInformationExpiredStrategy);
    }
}

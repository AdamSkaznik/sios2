package local.wpr.start.sios.configuration;

import local.wpr.start.sios.utils.CustomAuthenticationSuccessHandler;
import local.wpr.start.sios.utils.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private MyUserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String loginPage = "/login";
        String logoutPage = "/logout";

        http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(loginPage).permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/templates/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/datatables/**").permitAll()
                .antMatchers("/uploadProcedures/**").fullyAuthenticated()
                .antMatchers("/uploadAttachment/**").fullyAuthenticated()
                .antMatchers("/uploadBranchClosed/**").fullyAuthenticated()
                .antMatchers("/uploadFailuresFiles/**").fullyAuthenticated()
                .antMatchers(HttpMethod.GET,"/api/unsecured/**").permitAll()
                .antMatchers("/restrict/**").fullyAuthenticated()
//                .antMatchers("/api/**").fullyAuthenticated()
                .antMatchers("/hospital/**").hasAnyAuthority("HOSPITAL_ADMIN", "HOSPITAL_USER", "GLOBAL_ADMIN")
                .antMatchers("/nfz/**").hasAnyAuthority("NFZ_ADMIN", "NFZL_USER", "GLOBAL_ADMIN")
                .antMatchers("/orm/**").hasAnyAuthority("ORM_ADMIN", "ORM_USER", "GLOBAL_ADMIN")
                .antMatchers("/wkrm/**").hasAnyAuthority("WKRM_ADMIN", "WKRM_USER", "GLOBAL_ADMIN")
//                .antMatchers("/wkrm/admin/**").hasAnyAuthority("WKRM_ADMIN", "GLOBAL_ADMIN")
                .antMatchers("/admin/**").hasAuthority("GLOBAL_ADMIN")
                .anyRequest()
                .authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage(loginPage)
                .loginPage("/")
                .failureUrl("/login?error=true")
                .successHandler(customSuccessHandler())
//                .defaultSuccessUrl("/restrict/index")
                .usernameParameter("user_name")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/404");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/templates/**","/images/**", "/webjars/**", "/datatables/**", "/srb/**", "/unsecured/**", "/assets/**", "/uploadProcedures/**");
    }

    @Bean
    public AuthenticationSuccessHandler customSuccessHandler(){
        return new CustomAuthenticationSuccessHandler();
    }

//    public class WebSecurityUnprotected extends WebSecurityConfigurerAdapter{
//        @Override
//        public void configure(WebSecurity webSecurity) throws Exception{
//            webSecurity.ignoring().mvcMatchers("/unsecured/**");
//        }
//    }

}

package tienganhmienphi.com.backend.Springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tienganhmienphi.com.backend.Springboot.security.CustomSuccessHandler;
import tienganhmienphi.com.backend.Springboot.service.Impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomSuccessHandler customSuccessHandler;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/", "/trang-chu","/*.html",
					"/favicon.ico","/**/*.jpg","/**/*.png",
					"/lien-he","/ve-chung-toi","/bai-viet","/bai-viet/**",
					"/dang-nhap","/dang-ky",
					"/khoa-hoc","/khoa-hoc/**","/**/*.html", "/**/*.css","/kiem-tra",
					"/**/*.js").permitAll()
			.antMatchers(HttpMethod.POST, "/api/v1/user","/api/v1/test/{id}","/api/v1/lecture/finish","/dang-ky").permitAll()
			.antMatchers("/quan-tri/**","/api/v1/**").hasAuthority("ADMIN")
			.anyRequest().authenticated()
			.and()
				.formLogin().permitAll()
				.loginPage("/dang-nhap")
				.failureUrl("/dang-nhap?error=true")
				.usernameParameter("email")
				.passwordParameter("password")
				.loginProcessingUrl("/doLogin").successHandler(customSuccessHandler)
			.and()
			.logout().permitAll()
			.and().rememberMe().and()
			.exceptionHandling().accessDeniedPage("/403")
			;
	}
}

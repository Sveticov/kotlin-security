package com.svetikov.kotlinsecurity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.web.server.ServerHttpSecurity.http
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.csrf.CsrfToken
import org.springframework.web.bind.annotation.CrossOrigin
import kotlin.jvm.Throws

@Configuration
@EnableWebSecurity
@CrossOrigin(origins = ["http://192.168.0.109:3000"])
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http


                .authorizeRequests()
                .antMatchers("/","index","/greeting","/add").permitAll() //"/greeting2"
                .antMatchers("/file","/greeting2").hasRole(MyRole.ADMIN.role)
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable()//csrfTokenRepository(CookieCsrfTokenRepository())


    }
    @Throws(Exception::class)
   override fun configure(webSecurity:WebSecurity){
        webSecurity.ignoring().antMatchers("/js/**","/css/**")
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder
    = BCryptPasswordEncoder()// PasswordEncoderFactories.createDelegatingPasswordEncoder()

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth

                .inMemoryAuthentication()
                .withUser("customer")
                .password(passwordEncoder().encode("12"))
                .roles(MyRole.USER.role)
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles(MyRole.ADMIN.role)
    }
}




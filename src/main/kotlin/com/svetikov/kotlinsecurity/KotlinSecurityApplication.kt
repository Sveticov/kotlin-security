package com.svetikov.kotlinsecurity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasAuthority
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.server.ServerHttpSecurity.http


@SpringBootApplication
//@EnableWebSecurity
class KotlinSecurityApplication



fun main(args: Array<String>) {
    runApplication<KotlinSecurityApplication>(*args)
}

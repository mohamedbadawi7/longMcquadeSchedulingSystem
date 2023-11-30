package com.Long.McQuade.SchedulingSystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class ProjectSecurityConfig {



    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery("select identifiernumber, pwd, enabled from users where identifiernumber=?");

        userDetailsManager.setAuthoritiesByUsernameQuery("select identifiernumber, authority from authorities where identifiernumber=?");

        return userDetailsManager;
    }



    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/homepage/").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/users/").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/users/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/users/add-admin").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.PUT, "/users/update-admin").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/users/delete-admin/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")

                        .requestMatchers(HttpMethod.GET, "/user-contacts/").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/user-contacts/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")

                        .requestMatchers(HttpMethod.GET, "/users/students/").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/users/students/s").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/users/students/*").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/users/students/*/").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/users/students/add-student").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.PUT, "/users/students/update-student").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/users/students/delete-student/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/users/students/get-lessons-by-student/*").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")


                        .requestMatchers(HttpMethod.GET, "/users/teachers/").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/users/teachers/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/users/teachers/add-teacher").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.PUT, "/users/teachers/update-teacher").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/users/teachers/delete-teacher/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/users/teachers/get-lessons-by-teacher/*").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")


                        .requestMatchers(HttpMethod.GET, "/lessons/").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/lessons/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/lessons/new-lesson").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.PUT, "/lessons/update-lesson").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/lessons/delete-lesson/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")

                        .requestMatchers(HttpMethod.GET, "/lesson-centres/").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/lesson-centres/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/lesson-centres/add-centre").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.PUT, "/lesson-centres/update-centre").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/lesson-centres/delete-centre/**").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")

                        .requestMatchers(HttpMethod.GET, "/users/students/request-lesson-change").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/users/requests").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/users/delete-request/*").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")

                        .requestMatchers(HttpMethod.GET, "/messages/").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/messages/for/*").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.POST, "/messages/send").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/messages/history/*/*").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.GET, "/messages/received/*").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT")
                        .requestMatchers(HttpMethod.DELETE, "/messages/delete/history/*/*").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT"))


        ;

        http.csrf(csrf -> csrf.disable());

        http.httpBasic(Customizer.withDefaults());

        http.cors(Customizer.withDefaults()); // Enable CORS


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }



}


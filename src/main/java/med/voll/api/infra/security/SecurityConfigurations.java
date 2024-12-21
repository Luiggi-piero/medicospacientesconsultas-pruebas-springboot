package med.voll.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // en la creacion de objetos, primero se escanean lo que esta anotado con Configuration, es prerriquisito para que otros elementos de la app puedan ser creados
@EnableWebSecurity  // para establecerlo como una configuración del contexto de seguridad, habilita el modulo EnableWebSecurity para esta clase
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    // retorna un tipo de objeto para que implemente una autenticacion stateless
    // securityFilterChain: sobreescribe el comportamiento de autenticacion
    @Bean  // indicamos que esta disponible en el contexto de spring
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests.requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers("/swagger-ui/",
                                "/swagger-ui/**",
                                "/swagger-ui/index.html",
                                "/v3/api-docs",
                                "/v3/api-docs/swagger-config").permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
        /*http.csrf(csrf -> csrf.disable()) // Deshabilitar CSRF
                .sessionManagement(sm ->
                        sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // tipo se sesion sin estado
                )
                .authorizeHttpRequests(req -> req
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .anyRequest().authenticated()
                )
                // agregamos nuestro filtro personalizado antes del filtro por defecto de spring security
                // UsernamePasswordAuthenticationFilter.class: define el tipo de autenticacion
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();*/
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean  // indicamos que esta disponible en el contexto de spring
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

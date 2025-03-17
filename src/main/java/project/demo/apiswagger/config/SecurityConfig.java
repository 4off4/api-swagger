package project.demo.apiswagger.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import project.demo.apiswagger.utility.SwaggerBeanUtility;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    @Autowired
    private final SwaggerBeanUtility swaggerBeanUtility;

    public String ip() {
        List<String> permitIpList = swaggerBeanUtility.getPermitIpList();
        StringBuilder ipAddress = new StringBuilder();

        int listSize = permitIpList.size();
        if (listSize > 0) {
            for (int i = 0; i < listSize; i++) {
                ipAddress.append("hasIpAddress('").append(permitIpList.get(i)).append("')");
                if (i < listSize - 1) ipAddress.append(" or ");
            }
        }
        return ipAddress.toString();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
                .authorizeHttpRequests(requests ->
                        requests.requestMatchers("/swagger-ui/**", "/v3/api-docs/**") .access(new WebExpressionAuthorizationManager(ip()))
                                .requestMatchers("/error").permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .build();
    }
}

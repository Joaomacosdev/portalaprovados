package br.com.portalconcurso.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Portal Concurso - API")
                        .description("API REST para gerenciamento de aprovados em concursos públicos")
                        .version("v1")
                        .contact(new Contact()
                                .name("João Marcos")
                                .email("joamarcosdev@gmail.com")
                                .url("https://github.com/Joaomacosdev"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}

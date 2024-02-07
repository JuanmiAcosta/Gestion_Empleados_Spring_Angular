package com.gestion.empleados.gestionempleadosbackend.context;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration // Capacidad de generar Beans (Diferentes componentes de Spring)
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gestion.empleados.gestionempleadosbackend")) //Busca dentro del paquete controller todas las clases @RestController
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Aplicación de Gestión de Empleados",
                "Gestión de Empleados",
                "v1",
                "Terms of service",
                new Contact("JuanmiAcosta", "https://github.com/JuanmiAcosta" , "acostaojuanmi@gmail.com"),
                "License of API",
                "URL of License of API",
                Collections.emptyList()
        );

    }
}

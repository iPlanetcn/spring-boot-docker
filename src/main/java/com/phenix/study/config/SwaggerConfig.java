package com.phenix.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger config
 *
 * json: http://localhost:8080/v2/api-docs
 * doc: http://localhost:8080/swagger-ui.html
 *
 * @author john
 * @since 2017-10-16
 */
@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                                                      .select()
                                                      .apis(RequestHandlerSelectors.basePackage("com.phenix.study"))
                                                      .paths(PathSelectors.any())
                                                      .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("spring-boot-docker APIs")
                                   .description("The project implemented by spring")
                                   .contact(new Contact("john", "http://www.xxx.com", "iplanetcn@gmail.com"))
                                   .license("Licence2.0")
                                   .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                                   .version("1.0")
                                   .build();
    }
}

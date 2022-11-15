package training.acabes.interservicecommunication.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@EnableSwagger2
@ConfigurationProperties("config.app.api")
@ConditionalOnProperty(name="config.app.api.swagger.enable", havingValue = "true", matchIfMissing = false)
public class SwaggerConfig {


    private String version;

    private String title;

    private String description;

    private String basePackage;

    private String contactName;

    private String contactEmail;


    @Bean


    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//         .apis(RequestHandlerSelectors.basePackage("training.acabes"))
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());

    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
//         .title("Spring Boot APIs")
                .title(title)
//         .description("Spring Boot APIs description")
                .description(description)
//        .version("1.0.0")
                .version(version)
//         .contact(new Contact("badusha", "null", "b@b.com"))
                .contact(new Contact(contactName, "null", contactEmail))
                .build();

    }


}

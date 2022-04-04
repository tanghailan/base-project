package com.coderman.configure;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author coderman
 * @Title: swagger配置
 * @Description: TOD
 * @date 2022/3/169:58
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigure {


    @Bean
    public Docket customerDocket() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("rest").apiInfo(apiInfo()).select()
                .paths(controllerPaths()).build().useDefaultResponseMessages(false)
                .produces(Sets.newHashSet("application/json"))
                .consumes(Sets.newHashSet("application/json"));
    }


    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("rpc").apiInfo(apiInfo()).select()
                .paths(apiPath()).build().useDefaultResponseMessages(false)
                .produces(Sets.newHashSet("application/json"))
                .consumes(Sets.newHashSet("application/json"));
    }

    private Predicate<String> apiPath() {
        return PathSelectors.regex("^[a-z0-9]{2,20}/*/api/.*");
    }


    @SuppressWarnings("all")
    private Predicate<String> controllerPaths() {
        return PathSelectors.any();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("cloud项目").version("1.0.0").build();
    }

}

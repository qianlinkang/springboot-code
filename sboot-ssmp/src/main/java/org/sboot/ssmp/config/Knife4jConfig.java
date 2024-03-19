package org.sboot.ssmp.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableKnife4j
public class Knife4jConfig {

    @Bean
    public Docket apiDocket(Environment environment) {
        // 设置要显示swagger环境
        Profiles profiles = Profiles.of("dev");
        // 判断是否处在在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 是否启动swagger
                .enable(flag)
                // 分组名称
                .groupName("api")
                // 设置哪些接口暴露给Swagger展示
                .select()

                /**
                 * 配置要扫描的接口的方式 RequestHandlerSelectors
                 * basePackage：指定要扫描的包
                 * any(): 扫描全部
                 * none()：不扫描
                 * withClassAnnotation(RestController.class): 扫描类上有RestController.class的注解
                 * withMethodAnnotation(GetMapping.class):    扫描方法上的注解
                 */
                // 指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("org.sboot.ssmp.controller.api"))
                // 扫描所有有注解的api，用这种方式更灵活
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 过滤请求路径
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    public Docket adminDocket(Environment environment) {
        // 设置要显示swagger环境
        Profiles profiles = Profiles.of("dev");
        // 判断是否处在在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 是否启动swagger
                .enable(flag)
                // 分组名称
                .groupName("admin")
                // 设置哪些接口暴露给Swagger展示
                .select()

                /**
                 * 配置要扫描的接口的方式 RequestHandlerSelectors
                 * basePackage：指定要扫描的包
                 * any(): 扫描全部
                 * none()：不扫描
                 * withClassAnnotation(RestController.class): 扫描类上有RestController.class的注解
                 * withMethodAnnotation(GetMapping.class):    扫描方法上的注解
                 */
                // 指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("org.sboot.ssmp.controller.admin"))
                // 扫描所有有注解的api，用这种方式更灵活
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))

                // 过滤请求路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("njupt", "https://xx", "xx@qq.com");

        return new ApiInfo(
                "ssmp",
                "api doc",
                "v1.0",
                "https://github.com/xx",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}

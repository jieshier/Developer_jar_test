package com.developer_jdk_test.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration	//声明该类为配置类
@EnableSwagger2	//声明启动Swagger2
@EnableWebMvc
public class SwaggerConfig {

//	@Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).host("developer.lsmaps.com/sdk-java").apiInfo(apiInfo())
//        		.tags(new Tag("BILL","提单"), getTags()).select()
//                .apis(RequestHandlerSelectors.basePackage("com.developer_jdk_test.controller")) //指明controller所在的包
//                .paths(PathSelectors.any()).build();
//    }
//
    private Tag[] getTags() {
        Tag[] tags = {
        };
        return tags;
    }
    @Bean
    public Docket docket(){
    	return new Docket(DocumentationType.SWAGGER_2).host("developer.lsmaps.com/sdk-java").apiInfo(apiInfo())
    			.tags(new Tag("BILL","提单"), getTags())
    			.tags(new Tag("Standard","标准化"), getTags())
    			.tags(new Tag("BusinessData","商业数据"), getTags()).
    			tags(new Tag("BulkSendMail","外贸邮-群发报告"), getTags()).select()
                .apis(RequestHandlerSelectors.basePackage("com.developer_jdk_test.controller")) //指明controller所在的包
                .paths(PathSelectors.any()).build();
    }
	
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("开放接口API")  //粗标题
//                .description("HTTP对外开放接口")   //描述
//                .version("1.0.0")   //api version
////                .termsOfServiceUrl("www.baidu.com")
//                .license("swagger.json")   //链接名称
//                .licenseUrl("https://developer.lsmaps.com/sdk-java/api/v2/api-docs")   //链接地址
////                .licenseUrl("http://localhost:8088/developer_jdk_test/v2/api-docs")   //链接地址
//                .build();
//    }
    
    private ApiInfo apiInfo(){
   	 
        return new ApiInfoBuilder()
                .title("开放接口API")
                .description("HTTP对外开放接口")
                .version("1.0")
                .build();
    }
}
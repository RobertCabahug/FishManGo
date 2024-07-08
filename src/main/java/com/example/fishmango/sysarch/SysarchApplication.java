package com.example.fishmango.sysarch;

import com.example.fishmango.sysarch.api.model.User;
import com.example.fishmango.sysarch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SysarchApplication implements CommandLineRunner {
	private final UserRepository userRepository;

	@Autowired
    public SysarchApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	public static void main (String[] args) {
		SpringApplication.run(SysarchApplication.class, args);
	}


    @Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		return builder.build();
	}



	@Override
	public void run(String... args) throws Exception {

	}
}

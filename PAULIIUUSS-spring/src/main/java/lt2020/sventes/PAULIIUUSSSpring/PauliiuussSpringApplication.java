package lt2020.sventes.PAULIIUUSSSpring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@EnableSwagger2
@SpringBootApplication
public class PauliiuussSpringApplication extends SpringBootServletInitializer {

	@Bean
	public Docket swaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("lt2020.sventes"))
				.build();
	}
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("IT Akademija REST Documentation")
				.version("v1")
				.build();
	}

	public static void main(String[] args) { SpringApplication.run(PauliiuussSpringApplication.class, args); }

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources (PauliiuussSpringApplication.class);
	}
}

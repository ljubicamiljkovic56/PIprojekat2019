package projekat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude = JpaRepositoriesAutoConfiguration.class)
@ComponentScan(basePackages= {"projekat.model", "projekat.controller", "projekat.service.intrfc", "projekat.service.services", "projekat.repository", "projekat.dto"})
@EntityScan(basePackages = {"projekat.model"})
@EnableJpaRepositories("projekat.repository")
public class PIprojekat2019Application extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PIprojekat2019Application.class);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(PIprojekat2019Application.class, args);
	}
}

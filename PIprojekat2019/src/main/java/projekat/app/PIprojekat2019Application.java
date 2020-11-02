package projekat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude = JpaRepositoriesAutoConfiguration.class)
@ComponentScan(basePackages= {"projekat.model"})
@EntityScan(basePackages = {"projekat.model"})
public class PIprojekat2019Application extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PIprojekat2019Application.class);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(PIprojekat2019Application.class, args);
	}
}

package it.sirfin.rubricaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"it.sirfin.rubricaserver"})
@EnableJpaRepositories(basePackages = {"it.sirfin.rubricaserver.repository"})
@EntityScan(basePackages = {"it.sirfin.rubricaserver.model"})
public class RubricaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RubricaServerApplication.class, args);
	}

}

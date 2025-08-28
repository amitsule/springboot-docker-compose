package com.cognitech.springboot_docker_compose;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringbootDockerComposeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerComposeApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(JdbcConnectionDetails jdbc)
    {
        return args -> {
            String details = "class: " + jdbc.getDriverClassName() + "\nurl: " + jdbc.getJdbcUrl();
            System.out.println(details);
        };
    }

}

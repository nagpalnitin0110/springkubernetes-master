package in.springboot.webservice.springboottech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring/application-context.xml"})
public class SpringBootTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTechApplication.class, args);
	}

}

/**Este software é de propriedade do Grupo 2 do curso de Sistemas de Informação da PUC-SP 2017.*/
package br.com.sagti;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.sagti.model")
@EntityScan(basePackages = "br.com.sagti.model.entity")
@ComponentScan(basePackages = "br.com.sagti")
@EnableAutoConfiguration
public class Boot {

	public static void main(String[] args) {
		SpringApplication sagti = new SpringApplication();
		sagti.addListeners(new StartupEventHandler());
		sagti.setSources(new HashSet<>(Arrays.asList(Boot.class)));
		sagti.run(args);
	}

}

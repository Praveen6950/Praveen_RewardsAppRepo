package retail.offer.rewardsprogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "retail.offer.rewardsprogram")
public class RewardsprogramApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RewardsprogramApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RewardsprogramApplication.class);
	}
}
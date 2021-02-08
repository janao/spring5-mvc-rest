package guru.springfamework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5MvcRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5MvcRestApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunnerBean() {
//		return (args) -> {
//			System.out.println("*** START ***");
//			System.out.println("In CommandLineRunnerImpl ");
//
//			for (String arg : args) {
//				System.out.println(arg);
//			}
//			System.out.println("*** STOP ***");
//		};
//	}
//
//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//		};
//	}
}

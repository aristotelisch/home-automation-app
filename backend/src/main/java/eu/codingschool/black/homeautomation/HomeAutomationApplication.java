package eu.codingschool.black.homeautomation;

import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import eu.codingschool.black.homeautomation.services.DeviceService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class HomeAutomationApplication {

	public static void main (String[] args) {
		SpringApplication.run (HomeAutomationApplication.class, args);
	}

	@Bean
	ApplicationRunner init (DeviceService service) {
		return args -> {
			Stream.of ("Bolt Usain", "Louis Spiros", "Micheal 'papias' Johnson").forEach (name -> {
				Device device = new Device ();
				device.setName (name);
				service.save(device);
			});
			service.findAll ().forEach (System.out::println);
		};

	}
}



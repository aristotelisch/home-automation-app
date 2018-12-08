package eu.codingschool.black.homeautomation;

import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.entities.PersonRole;
import eu.codingschool.black.homeautomation.entities.Room;
import eu.codingschool.black.homeautomation.repositories.PersonRoleRepository;
import eu.codingschool.black.homeautomation.services.DeviceService;
import eu.codingschool.black.homeautomation.services.PersonService;
import eu.codingschool.black.homeautomation.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class HomeAutomationApplication implements CommandLineRunner {

	@Autowired
	DeviceService deviceService;

	@Autowired
	RoomService roomService;

	@Autowired
	PersonService personService;

	@Autowired
	PersonRoleRepository personRoleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main (String[] args) {
		SpringApplication.run (HomeAutomationApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception {
		Room lRoom1 = new Room ("Living Room", "living_room.jpg");
		roomService.save (lRoom1);

		Room lRoom2 = new Room ("Bedroom", "bedroom.jpg");
		roomService.save (lRoom2);

		Room lRoom3 = new Room ("Kitchen", "kitchen.jpg");
		roomService.save (lRoom3);

		Room lRoom4 = new Room ("Bathroom", "bathroom.jpg");
		roomService.save (lRoom4);

		Room lRoom5 = new Room ("Garage", "garage.jpg");
		roomService.save (lRoom5);

		Room lRoom6 = new Room ("Yard", "yard.jpg");
		roomService.save (lRoom6);

		deviceService.save (new Device ("Living Room Light 1", "onoff", true, "Living Room Light is Switched ON", lRoom1));
		deviceService.save (new Device ("Living Room Light 2", "onoff", true, "Living Room Light is Switched ON", lRoom1));
		deviceService.save (new Device ("Bedroom Light 1", "onoff", true, "Bedroom Light is Switched ON", lRoom2));
		deviceService.save (new Device ("Bedroom Light 2", "onoff", true, "Bedroom Light is Switched ON", lRoom2));
		deviceService.save (new Device ("Kitchen Light", "onoff", true, "Kitchen Light is Switched ON", lRoom3));
		deviceService.save (new Device ("Oven", "onoff", true, "Oven is turned ON", lRoom3));
		deviceService.save (new Device ("Refrigerator", "onoff", true, "Refrigerator is turned ON", lRoom3));
		deviceService.save (new Device ("Bathroom Light", "onoff", true, "Bathroom Light is turned ON", lRoom4));
		deviceService.save (new Device ("Jacuzzi", "onoff", true, "Jacuzzi is warming", lRoom4));
		deviceService.save (new Device ("Garage Light", "onoff", true, "Garage Light is switched ON", lRoom5));
		deviceService.save (new Device ("Garage Door", "onoff", true, "Garage Door is opened", lRoom5));
		deviceService.save (new Device ("Yard Light", "onoff", true, "Yard Light is turned ON", lRoom6);
		deviceService.save (new Device ("Fountain", "onoff", true, "Fountain is making everyone wet", lRoom6);




		PersonRole userRole = new PersonRole ("ROLE_USER");
		PersonRole adminRole = new PersonRole ("ROLE_ADMIN");
		personRoleRepository.save(userRole);
		personRoleRepository.save(adminRole);

		Person simpleUser = new Person();
		simpleUser.setUsername ("user");
		simpleUser.setPassword ("password");
		simpleUser.setPersonrole (userRole);
		personService.save (simpleUser);

		Person adminUser = new Person();
		adminUser.setUsername ("admin");
		adminUser.setPassword ("password");
		adminUser.setPersonrole (adminRole);
		personService.save (adminUser);



		roomService.findAll ().forEach (room -> System.out.println (room.getName ()));
		deviceService.findAll ().forEach (device -> System.out.println (device.getName ()));
	}
}


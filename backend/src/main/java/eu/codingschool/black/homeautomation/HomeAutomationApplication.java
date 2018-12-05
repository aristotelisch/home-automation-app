package eu.codingschool.black.homeautomation;

import eu.codingschool.black.homeautomation.entities.Device;
import eu.codingschool.black.homeautomation.entities.Room;
import eu.codingschool.black.homeautomation.repositories.DeviceRepository;
import eu.codingschool.black.homeautomation.services.DeviceService;
import eu.codingschool.black.homeautomation.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class HomeAutomationApplication implements CommandLineRunner {

	@Autowired
	DeviceService deviceService;

	@Autowired
	RoomService roomService;

	public static void main (String[] args) {
		SpringApplication.run (HomeAutomationApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception {

	  Room lRoom1 = new Room ("Living Room", "living_room.jpg");
		roomService.save (lRoom1);
		Room lRoom2 = new Room ("Bedroom", "bedroom.jpg");
		roomService.save (lRoom2);

		deviceService.save (new Device ("Living Room Light 1", "onoff", true, "Living Room Light is Switched ON", lRoom1));
		deviceService.save (new Device ("Living Room Light 2", "onoff", true, "Living Room Light is Switched ON", lRoom1));
		deviceService.save (new Device ("Bedroom Light 1", "onoff", true, "Living Room Light is Switched ON", lRoom2));
		deviceService.save (new Device ("Bedroom Light 2", "onoff", true, "Living Room Light is Switched ON", lRoom2));

		roomService.findAll ().forEach (System.out::println);
		roomService.findAll ().forEach (room -> System.out.println (room.getName ()));
		deviceService.findAll ().forEach (device -> System.out.println (device.getName ()));
	}


}



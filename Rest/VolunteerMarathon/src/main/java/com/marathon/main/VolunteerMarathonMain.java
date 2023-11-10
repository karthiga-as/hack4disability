package com.marathon.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.marathon.*"})
public class VolunteerMarathonMain {

	public static void main(String[] args) {
		SpringApplication.run(VolunteerMarathonMain.class, args);

	}

}

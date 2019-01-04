package com.harrisonphung.Notifier;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NotifierApplication implements ApplicationRunner, CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(NotifierApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		System.out.println("Application Runner example");
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("Command Line Runner example");
	}
}

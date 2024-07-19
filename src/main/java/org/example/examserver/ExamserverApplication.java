package org.example.examserver;

import org.example.examserver.Services.UserService;
import org.example.examserver.entity.Role;
import org.example.examserver.entity.User;
import org.example.examserver.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication {



	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);


	}

}

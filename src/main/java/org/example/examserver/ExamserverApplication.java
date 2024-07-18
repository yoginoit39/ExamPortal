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
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");

		User user = new User();

		user.setFirstname("Yogesh");
		user.setLastname("Lakhani");
		user.setUsername("yogesh1997");
		user.setPassword("abc");
		user.setEmail("abc@gmail.com");
		user.setProfile("default.png");

		Role role1 = new Role();
		role1.setRoleId(1l);
		role1.setRoleName("ADMIN");


		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);



		userRoleSet.add(userRole);

		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user.getUsername());


	}
}

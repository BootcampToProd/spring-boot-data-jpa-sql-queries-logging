package com.bootcamptoprod;

import com.bootcamptoprod.entity.User;
import com.bootcamptoprod.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootDataJpaSqlQueriesLoggingApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJpaSqlQueriesLoggingApplication.class, args);
    }

    @Override
    public void run(String... args) {

        // Insert
        System.out.println("\nStarting Insert Operations");

        User user1 = new User();
        user1.setName("John Doe");
        user1.setEmail("john.doe@example.com");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Jane Doe");
        user2.setEmail("jane.doe@example.com");
        userRepository.save(user2);

        System.out.println("\nInsert Operations Completed");

       /* // Select
        System.out.println("\nStarting Select All Users Operation");
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);*/

        System.out.println("\nSelect All Users Operation Completed");

        // Update
        System.out.println("\nStarting Update Operation");
        User userToUpdate = userRepository.findById(user1.getId()).orElseThrow();
        userToUpdate.setEmail("new.john.doe@example.com");
        userRepository.save(userToUpdate);

        System.out.println("\nUpdate Operation Completed");

        // Delete
        System.out.println("\nStarting Delete Operation");
        userRepository.deleteById(user2.getId());

        System.out.println("\nDelete Operation Completed");


        // Select with parameter
        System.out.println("\nStarting Select with Parameter Operation");
        List<User> johns = userRepository.findByName("John Doe");
        johns.forEach(System.out::println);

        System.out.println("\nSelect with Parameter Operation Completed");
    }
}

package com.messageService.message;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MessageConfig {

    @Bean
    CommandLineRunner commandLineRunner(MessageRepository repository) {
        return args -> {

           Message one = new Message(1, "Good morning everyone", "Jennifer");
           Message two = new Message(2, "Meeting every Monday at 10 a.m.", "Bryan");
           Message three = new Message(3,"Janitor found the keys at the meeting room", "Bonnie");

           repository.saveAll(List.of(one, two, three));


        };
    }
}

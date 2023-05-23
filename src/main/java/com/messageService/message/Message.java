package com.messageService.message;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString

@Entity(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private @Getter
    @Setter long id;
    private @Getter
    @Setter String text;
    private @Getter
    @Setter String sender;

}

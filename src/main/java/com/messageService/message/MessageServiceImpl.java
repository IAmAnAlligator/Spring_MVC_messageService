package com.messageService.message;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageServices {

    private final MessageRepository repository;


    @Autowired
    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Message> getMessages() {
        return repository.findAll();
    }

    @Override
    public void deleteMessage() {
        repository.deleteById(repository.findAll()
                .get(repository.findAll().size() - 1)
                .getId());
    }

    @Override
    public void save(Message message) {
        repository.save(message);
    }

    @Query(value = "SELECT * FROM Messages u WHERE u.sender= ?1",
            nativeQuery = true)
    public List<Message> findMessagesBySender(String sender) {
        return repository.findMessagesBySender(sender);
    }

}

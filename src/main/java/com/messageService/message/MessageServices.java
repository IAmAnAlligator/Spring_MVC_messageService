package com.messageService.message;

import java.util.List;

public interface MessageServices {

    List<Message> getMessages();
    void deleteMessage();
    void save(Message message);

    List<Message> findMessagesBySender(String sender);
}

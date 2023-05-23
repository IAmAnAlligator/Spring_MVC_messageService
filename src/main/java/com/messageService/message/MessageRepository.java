package com.messageService.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(value = "SELECT * FROM Messages u WHERE u.sender= ?1",
            nativeQuery = true)
    List<Message> findMessagesBySender(String sender);

}

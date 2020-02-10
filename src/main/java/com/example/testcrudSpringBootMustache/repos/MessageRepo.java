package com.example.testcrudSpringBootMustache.repos;

import com.example.testcrudSpringBootMustache.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {

    Message findByTag(String tag);

    Message findById (long id);

    List<Message> findByText(String name);
}

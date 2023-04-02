package com.mistressfilth.spring.repo;

import com.mistressfilth.spring.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}

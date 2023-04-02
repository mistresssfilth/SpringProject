package com.mistressfilth.spring.repo;

import com.mistressfilth.spring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
}

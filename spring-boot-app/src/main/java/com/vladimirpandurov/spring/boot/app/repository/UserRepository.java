package com.vladimirpandurov.spring.boot.app.repository;

import com.vladimirpandurov.spring.boot.app.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByNameContaining(String name, Pageable page);

}

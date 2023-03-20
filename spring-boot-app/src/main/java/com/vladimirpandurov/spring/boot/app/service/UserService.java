package com.vladimirpandurov.spring.boot.app.service;

import com.vladimirpandurov.spring.boot.app.domain.User;
import com.vladimirpandurov.spring.boot.app.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public Page<User> getUsers(String name, int page, int size){
        return userRepository.findByNameContaining(name, PageRequest.of(page, size));
    }


}

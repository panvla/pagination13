package com.vladimirpandurov.spring.boot.app.controlloer;

import com.vladimirpandurov.spring.boot.app.domain.HttpResponse;
import com.vladimirpandurov.spring.boot.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<HttpResponse> findUsers(@RequestParam Optional<String> name,
                                                  @RequestParam Optional<Integer> page,
                                                  @RequestParam Optional<Integer> size){
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                .timeStamp(LocalDateTime.now().toString())
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Users Retrieved")
                .data(Map.of("page", this.userService.getUsers(name.orElse(""), page.orElse(0), size.orElse(10))))
                .build()
        );
    }

}

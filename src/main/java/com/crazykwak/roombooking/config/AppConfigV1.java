package com.crazykwak.roombooking.config;

import com.crazykwak.roombooking.user.repository.UserRepository;
import com.crazykwak.roombooking.user.repository.memory.MemoryRepository;
import com.crazykwak.roombooking.user.service.UserService;
import com.crazykwak.roombooking.user.service.UserServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigV1 {

    @Bean
    public UserRepository userRepository() {
        return new MemoryRepository();
    }

    @Bean
    public UserService userService() {
        return new UserServiceV1(userRepository());
    }

}

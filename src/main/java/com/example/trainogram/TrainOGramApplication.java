package com.example.trainogram;

import com.example.trainogram.dao.repositories.PostRepository;
import com.example.trainogram.dao.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@AllArgsConstructor
public class TrainOGramApplication implements CommandLineRunner {

//    private final PostRepository postRepository;
//    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
//    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(TrainOGramApplication.class, args);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

    }
}

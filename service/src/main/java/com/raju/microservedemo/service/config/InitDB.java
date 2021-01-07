package com.raju.microservedemo.service.config;

import com.raju.microservedemo.service.model.Authority;
import com.raju.microservedemo.service.model.User;
//import com.raju.microservedemo.service.repository.AuthorityRepository;
import com.raju.microservedemo.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InitDB implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private AuthorityRepository authorityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
//        authorityRepository.deleteAll();
        Authority a1 = new Authority(  "ROLE_USER");
        Authority a2 = new Authority( "ROLE_ADMIN");


        User u1 = new User(null, "admin",
                this.passwordEncoder.encode("admin"),
                "Mr.",
                "admin",
                "admin@raju.com",
                true,
                Stream.of(a1, a2).collect(Collectors.toSet()));

        User u2 = new User(null, "raju",
                this.passwordEncoder.encode("raju"),
                "Mr.",
                "raju",
                "raju@raju.com",
                true,
                Stream.of(a1).collect(Collectors.toSet()));

        User u3 = new User(null, "inactive",
                this.passwordEncoder.encode("inactive"),
                "Mr.",
                "inactive",
                "inactive@raju.com",
                false,
                Stream.of(a1).collect(Collectors.toSet()));


        userRepository.saveAll(Arrays.asList(u1, u2, u3));


    }
}

package com.UserService.UserService;

import io.micrometer.tracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ServiceClass implements UserService{
    @Autowired
    private Tracer tracer;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {


        userRepository.save(user);
        log.info("User has been created user is : "+user.toString());
        return user;
    }

    @Override
    public List<User> getAllUsers(){
        List<User> list = userRepository.findAll();
        return list;
    }

    @Override
    public User getUser(int id) {
        log.info("UserService TraceId : {}",
                tracer.currentSpan().context().traceId());

       User user =  userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found!"));
       log.info("User has been get user is : "+user.toString());
       return user;
    }

    @Override
    public String deleteUser(int id) {

        userRepository.deleteById(id);
        log.info("User has been deleted which id is : "+id);
        return "User deleted! where id is : "+id;
    }
}

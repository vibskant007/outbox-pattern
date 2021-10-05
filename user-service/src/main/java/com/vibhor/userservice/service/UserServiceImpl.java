package com.vibhor.userservice.service;

import com.vibhor.userservice.model.User;
import com.vibhor.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventPublish eventPublish;

    @Autowired
    Mapper mapper;


    @Override
    @Transactional
    public void createUser(User user) {
        userRepository.save(user);
        try {
            eventPublish.publishEvent(mapper.mapUserToOutboxEvent(user));
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package jp.ac.tama.service;

/**
 * Created by owner on 2016/08/04.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

import jp.ac.tama.entity.UserEntity;
import jp.ac.tama.model.User;
import org.springframework.http.ResponseEntity;
import jp.ac.tama.repository.UserRepository;
import org.springframework.web.client.RestTemplate;
import lombok.val;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Iterable<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public void addUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public Iterable<UserEntity> getRestArrayEntity() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserEntity[]> responseEntity = restTemplate.getForEntity("https://fast-reef-14433.herokuapp.com/prefectures", UserEntity[].class);
        val userEntities = new ArrayList<UserEntity>();
        for (UserEntity userEntity:responseEntity.getBody()) {
            userEntities.add(userEntity);
        }
        return userEntities;
    }

    public User getRestEntity() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("https://fast-reef-14433.herokuapp.com/prefectures", User.class);
        return responseEntity.getBody();
    }
}
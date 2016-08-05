package jp.ac.tama.controller;

/**
 * Created by owner on 2016/08/04.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jp.ac.tama.entity.UserEntity;
import jp.ac.tama.model.User;
import jp.ac.tama.service.UserService;
import lombok.val;

/**
 * Created by kajiwarayutaka on 2016/08/03.
 */
@RestController
@RequestMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "rest",method = RequestMethod.GET)
    public Iterable<UserEntity> showRestUsers(){
        return userService.getRestArrayEntity();
    }
    @RequestMapping(value = "{userName}",method = RequestMethod.GET)
    public User showUser(@PathVariable String userName){
        val user = new User(userName,"sfehisuf","10","fahsndkfja");
        return user;
    }
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Iterable<UserEntity> showUsers(){
        val users = userService.getUsers();
        return users;
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResponseEntity createUser(@Validated @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }else{
            val userEntity = new UserEntity(user.getName(),user.getPassword(),user.getPrefecture_id(),user.getToken());
            userService.addUser(userEntity);
            return new ResponseEntity<String>("OK!!",HttpStatus.CREATED);
        }

    }
}
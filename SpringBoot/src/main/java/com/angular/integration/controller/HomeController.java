package com.angular.integration.controller;

import com.angular.integration.model.User;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HomeController {

    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:8080"})
    @GetMapping("/getAllData")
    public String getAllData(){
        User user =new User("Arijit","patra","arijit.patra0001@gmail.com");
        User user1 =new User("Madhuri","roy","test1M@email.com");
        User user2 =new User("Adhrit","patra","test1Adhrit@email.com");
        List<User> listUser=new ArrayList<>();
        listUser.add(user);
        listUser.add(user1);
        listUser.add(user2);

    Gson gson =new Gson();
    return  gson.toJson(listUser);

    }
}

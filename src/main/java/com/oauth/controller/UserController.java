package com.oauth.controller;

import com.oauth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Created at: 21/11/2018 - 20:00
 */
@RestController
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity users(){
        List<User> users = new ArrayList<>();
        users.add(new User("Tiago", 33, "tiago", "123456"));
        users.add(new User("Henrique", 32, "henrique", "123456"));
        users.add(new User("Thalita", 28, "thalita", "123456"));
        users.add(new User("Felipe", 27, "felipe", "123456"));
        users.add(new User("Toichi", 05, "toichi", "123456"));

        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity info(@Autowired Principal principal){
        OAuth2Authentication userDetails = (OAuth2Authentication) principal;
        OAuth2AuthenticationDetails userOAuthDetails = (OAuth2AuthenticationDetails) userDetails.getDetails();

        System.out.println("oauth user details: " + userOAuthDetails);
        System.out.println("token type: " + userOAuthDetails.getTokenType());
        System.out.println("token value: " + userOAuthDetails.getTokenValue());
        System.out.println("decoded details: " + userOAuthDetails.getDecodedDetails());
        System.out.println("Ping on the server was successful.");

        return new ResponseEntity("Oi", HttpStatus.OK);
    }

}

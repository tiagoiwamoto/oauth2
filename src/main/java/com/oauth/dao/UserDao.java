package com.oauth.dao;

import com.oauth.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiago Henrique Iwamoto
 * Mail: tiago.iwamoto@gmail.com
 * Created at: 21/11/2018 - 20:35
 */
@Service
public class UserDao {

    public User findUser(String user, Integer idade){
        List<User> users = new ArrayList<>();
        users.add(new User("Tiago", 33, "tiago", "123456"));
        users.add(new User("Henrique", 32, "henrique", "123456"));
        users.add(new User("Thalita", 28, "thalita", "123456"));
        users.add(new User("Felipe", 27, "felipe", "123456"));
        users.add(new User("Toichi", 05, "toichi", "123456"));
        for(User usuario : users){
            if(usuario.getNome().equalsIgnoreCase(user) && usuario.getIdade() == idade){
                return usuario;
            }
        }
        return null;
    }

    public User findByName(String user){
        List<User> users = new ArrayList<>();
        users.add(new User("Tiago", 33, "tiago", "123456"));
        users.add(new User("Henrique", 32, "henrique", "123456"));
        users.add(new User("Thalita", 28, "thalita", "123456"));
        users.add(new User("Felipe", 27, "felipe", "123456"));
        users.add(new User("Toichi", 05, "toichi", "123456"));

        for(User usuario : users){
            if(usuario.getNome().equalsIgnoreCase(user)){
                return usuario;
            }
        }
        return null;
    }

}

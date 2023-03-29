package com.shopMeECommerce.services;

import com.shopMeECommerce.entities.Role;
import com.shopMeECommerce.entities.User;
import com.shopMeECommerce.repositories.RoleRepository;
import com.shopMeECommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User>listAll(){
        return (List<User>) userRepo.findAll();
    }

    public List<Role>listRoles(){
        return (List<Role>) roleRepo.findAll();
    }

    public void save(User user) {
        encodePassword(user);
        userRepo.save(user);
    }
    private void encodePassword(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
    public boolean isEmailUnique(String email){
       User userByEmail= userRepo.getUsersByEmail(email);
       return userByEmail == null; //  if returns null the  email is not unique
    }
}

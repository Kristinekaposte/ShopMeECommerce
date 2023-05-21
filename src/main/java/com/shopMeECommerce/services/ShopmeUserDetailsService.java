package com.shopMeECommerce.services;

import com.shopMeECommerce.classes.ShopmeUserDetails;
import com.shopMeECommerce.entities.User;
import com.shopMeECommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ShopmeUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepo.getUsersByEmail(email);
       if (user != null){
           return new ShopmeUserDetails(user);
       }
       throw new UsernameNotFoundException("Could not find user with email: " + email);
    }
}
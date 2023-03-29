package com.shopMeECommerce.repositories;

import com.shopMeECommerce.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User,Integer> {
}

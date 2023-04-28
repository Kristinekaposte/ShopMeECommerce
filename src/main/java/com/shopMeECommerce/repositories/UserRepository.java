package com.shopMeECommerce.repositories;

import com.shopMeECommerce.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends PagingAndSortingRepository<User,Integer>,CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User getUsersByEmail(@Param("email") String email);
    public Long countById(Integer id);
    @Query("UPDATE User u SET u.enabled = ?2 where u.id = ?1")
    @Modifying
    public void updateEnabledStatus(Integer id, boolean enabled);

//    public void findById (Integer id);
}

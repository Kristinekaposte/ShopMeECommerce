package com.shopMeECommerce.test;

import com.shopMeECommerce.entities.Role;
import com.shopMeECommerce.entities.User;
import com.shopMeECommerce.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateNewUserWithOneRole(){
        Role roleAdmin = entityManager.find(Role.class,1);
        User userSarahF= new User("email@email.com", "123456", "Sarah" ,"Forest");
        userSarahF.addRole(roleAdmin);

       User savedUser =  repo.save(userSarahF);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testCreateNewUserWithTwoRoles(){
        User userJohn =new User("email2@email.com", "123456", "John" ,"Forest");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);
        userJohn.addRole(roleEditor);
        userJohn.addRole(roleAssistant);
        User savedUser = repo.save(userJohn);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public  void testListAllUsers(){
       Iterable<User> listUsers = repo.findAll();
       listUsers.forEach(user -> System.out.println(user));
    }
    @Test public void testGetUserById(){
       User userSarah = repo.findById(1).get();
       System.out.println(userSarah);
        assertThat(userSarah).isNotNull();
    }
    @Test
    public void testUpdateUserDetails(){
        User userSarah = repo.findById(1).get();
        userSarah.setEnabled(true);
        userSarah.setEmail("sarah@email.com");

        repo.save(userSarah);
    }

    @Test
    public void testUpdateUserRoles(){
        User userJohn = repo.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSalesperson = new Role(2);
        userJohn.getRoles().remove(roleEditor);

        userJohn.addRole(roleSalesperson);
        repo.save(userJohn);
    }
    @Test
    public void testDeleteUser(){
        Integer userId=2;
        repo.deleteById(userId);
    }
    @Test
    public void testGetUserByEmail(){
        String email="mikeforest@email.com";
        User user= repo.getUsersByEmail(email);
        assertThat(user).isNotNull();
    }

    @Test
    public void testCountById(){
        Integer id=3;
       Long countById = repo.countById(id);
        assertThat(countById).isNotNull().isGreaterThan(0);
    }
    @Test
    public void testDisableUser(){
        Integer id=1;
       repo.updateEnabledStatus(id,false);
    }
    @Test
    public void testEnableUser(){
        Integer id=3;
        repo.updateEnabledStatus(id,true);
    }
}

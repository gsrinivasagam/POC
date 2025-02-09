package com.jpa.entity.app.rest.Controller;


import com.jpa.entity.app.rest.PrimaryEntity.User;
import com.jpa.entity.app.rest.PrimaryRepo.UserRepository;
import com.jpa.entity.app.rest.Repo.UserRepo;
import com.jpa.entity.app.rest.SecondaryEntity.Order;
import com.jpa.entity.app.rest.SecondaryRepo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    //@Autowired
    //private UserRepo userRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private OrderRepository orderRepo;

    @GetMapping(value ="/")
    public String getPage(){
        return "welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @GetMapping(value = "/orders")
    public List<Order> getOrders(){
        return orderRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved...";
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
       User updatedUser =  userRepo.findById(id).get();
//       updatedUser.setFirstName(user.getFirstName());
//       updatedUser.setLastName(user.getLastName());
//       updatedUser.setAge(user.getAge());
//       updatedUser.setOccupation(user.getOccupation());
       userRepo.save(updatedUser);
       return "updated ...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User userToDelete = userRepo.findById(id).get();
        userRepo.delete(userToDelete);
        return "deleted";
    }


}

package com.jpa.entity.app.rest.Service;

import com.jpa.entity.app.rest.SecondaryEntity.Order;
import com.jpa.entity.app.rest.PrimaryEntity.User;
import com.jpa.entity.app.rest.SecondaryRepo.OrderRepository;
import com.jpa.entity.app.rest.PrimaryRepo.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public DataService(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public List<User> getUsers() { return userRepository.findAll(); }
    public List<Order> getOrders() { return orderRepository.findAll(); }
}

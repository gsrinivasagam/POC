package com.jpa.entity.app.rest.SecondaryRepo;

import com.jpa.entity.app.rest.SecondaryEntity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}

package com.jpa.entity.app.rest.PrimaryRepo;


import com.jpa.entity.app.rest.PrimaryEntity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {}

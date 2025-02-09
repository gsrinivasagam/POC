package com.jpa.entity.app.rest.SecondaryRepo;


import com.jpa.entity.app.rest.SecondaryEntity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {}

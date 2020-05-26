package com.mindbowser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindbowser.model.ManagerEntity;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity,Integer>{

}

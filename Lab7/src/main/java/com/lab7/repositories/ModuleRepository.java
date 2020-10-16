package com.lab7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab7.models.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer> {

}

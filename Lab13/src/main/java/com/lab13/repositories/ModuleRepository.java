package com.lab13.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab13.models.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer> {

}

package com.lab9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab9.models.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer> {

}

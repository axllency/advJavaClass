package com.lab12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab12.models.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer> {

}

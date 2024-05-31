package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MateriasEntity;

@Repository
public interface IMateriasReposytory extends JpaRepository<MateriasEntity, Long>{

}

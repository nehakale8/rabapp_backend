package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Population;

@Repository
public interface PopulationRepository extends JpaRepository<Population, Long>{

	Optional<Population> findByPid(String pid);
//	void updatePopulation(Population population);
}

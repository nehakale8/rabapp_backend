package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movements;
import com.example.demo.model.Population;
import com.example.demo.repository.MovementsRepository;
import com.example.demo.repository.PopulationRepository;
import com.example.demo.service.PopulationService;

@RestController
@RequestMapping("/api/v1/")
public class MovementsController {

	@Autowired
	private MovementsRepository movementsRepository;
	
	@Autowired
	private PopulationService populationService;
	
	@GetMapping("/movements")
	public List<Movements> getAllMovements(){
		return movementsRepository.findAll();
	}
	
	@PostMapping("/movements")
	public Movements createMovements(@RequestBody Movements movements){
		Population origin = populationService.getProductById(movements.getOrigin_premise_id());
		Population destination = populationService.getProductById(movements.getDest_premise_id());
		
		populationService.setAnimalCount(origin.getPremise_id(), origin.getTotal_animal_count()-movements.getMoved_count());
		populationService.setAnimalCount(destination.getPremise_id(), destination.getTotal_animal_count()+movements.getMoved_count());
		
		//origin.setTotal_animal_count(origin.getTotal_animal_count()-movements.getMoved_count());
		//destination.setTotal_animal_count(destination.getTotal_animal_count()+movements.getMoved_count());

		
		return movementsRepository.save(movements);
	}
	
}

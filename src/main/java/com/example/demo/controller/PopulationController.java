package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Population;

import com.example.demo.repository.PopulationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import com.example.demo.service.PopulationService;


@RestController
@RequestMapping("/api/v1/")
public class PopulationController {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
    private PopulationService service;


	@Autowired
	private PopulationRepository populationRepository;
	
	// get employee rest api
	@GetMapping("/population")
	public List<Population> getAllPopulation(){
		return populationRepository.findAll();
	}
	
	@GetMapping("/population/{id}")
    public Population getProductById(@PathVariable String id) {
        return service.getProductById(id);
    }
	
	// create employee rest api
	@PostMapping("/population")
	public Population createPopulation(@RequestBody Population population){
		return populationRepository.save(population);
	}
	

	@PatchMapping("/population/{id}")
    public Population updateProductFields(@PathVariable String id,@RequestBody Map<String, Object> fields){
        return service.updateProductByFields(id,fields);
    }
	
	// update employee rest api
	@CrossOrigin
	@PutMapping("/population/{pid}")
	public ResponseEntity<Population> updatePopulation(@PathVariable String pid, @RequestBody Population populationDetails){
		Population population = populationRepository.findByPid(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Population does not exist with id :" + pid));
		
		population.setTotal_animal_count(populationDetails.getTotal_animal_count());
		
		Population updatedPopulation = populationRepository.save(population);
		return ResponseEntity.ok(updatedPopulation);
	}
	
	
	
//	@PatchMapping(path = "/{pid}", consumes = "application/json-patch+json")
//	public ResponseEntity<Population> updatePopulation(@PathVariable String pid, @RequestBody JsonPatch patch) {
//	    try {
//	    	Population population = populationRepository.findByPid(pid)
//	    			.orElseThrow(() -> new ResourceNotFoundException("Population does not exist with id :" + pid));
//	    	
//	    	JsonNode patched = patch.apply(objectMapper.convertValue(population, JsonNode.class));
//	    	Population populationPatched = objectMapper.treeToValue(patched, Population.class);
//	    	
//	    	populationRepository.updatePopulation(populationPatched);
//	    	
//	        return ResponseEntity.ok(populationPatched);
//	    } catch (ResourceNotFoundException e) {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//	    } catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonPatchException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	


}

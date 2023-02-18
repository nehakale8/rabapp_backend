package com.example.demo.service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.demo.model.Population;
import com.example.demo.repository.PopulationRepository;

@Service
public class PopulationService {

	@Autowired
    private PopulationRepository repository;
	
	public Population getProductById(String id) {
        return repository.findByPid(id).get();
    }
	
	
	public Population updateProductByFields(String id, Map<String, Object> fields) {
        Optional<Population> existingProduct = repository.findByPid(id);

        if (existingProduct.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Population.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingProduct.get(), value);
            });
            return repository.save(existingProduct.get());
        }
        return null;
    }

	public boolean setAnimalCount(String premId, int animalCount) {
		Optional<Population> premise = repository.findByPid(premId);
		if (premise.isPresent()) {
			premise.get().setTotal_animal_count(animalCount);
			repository.save(premise.get());
			return true;			
		}
		return false;
	}
}



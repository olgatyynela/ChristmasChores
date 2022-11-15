package com.example.ChristmasChores.domain;

import org.springframework.data.repository.CrudRepository;


public interface ChoreRepository extends CrudRepository<Chore, Long> {
	 
}
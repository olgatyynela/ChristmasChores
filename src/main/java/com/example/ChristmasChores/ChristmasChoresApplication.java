package com.example.ChristmasChores;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ChristmasChores.domain.ChoreRepository;
import com.example.ChristmasChores.domain.Tekija;
import com.example.ChristmasChores.domain.TekijaRepository;


@SpringBootApplication
public class ChristmasChoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChristmasChoresApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(ChoreRepository crepository, TekijaRepository trepository) {return (args) -> {
		Tekija t1 = new Tekija("Tapio");
		Tekija t2 = new Tekija("Olga");
		Tekija t3 = new Tekija("Julia");
		Tekija t4 = new Tekija("Taneli");
		Tekija t5 = new Tekija("Ilari");

		
		trepository.save(t1);
		trepository.save(t2);
		trepository.save(t3);
		trepository.save(t4);
		trepository.save(t5);
		

			
		};
	}
}

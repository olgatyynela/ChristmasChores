package com.example.ChristmasChores.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.ChristmasChores.domain.Chore;
import com.example.ChristmasChores.domain.ChoreRepository;
import com.example.ChristmasChores.domain.TekijaRepository;



@Controller
public class ChoreController {

	@Autowired
	private ChoreRepository crepository;
	@Autowired
	private TekijaRepository trepository;
	
	// kaks ekaa bookcontrollerista puuttuu tästä, mitä ne tekee?
	
	@GetMapping("/chores")
	  public String ChoreList(Model model) {
		model.addAttribute("chores", crepository.findAll());
		return "chores";
	  }
	
	@GetMapping("/addchorepage")
	public String addChorepage(Model model) {
		model.addAttribute("chore", new Chore());
		model.addAttribute("tekijat", trepository.findAll());
	    return "addchore";
	}
	
	@PostMapping("/addchore")
	public String addChore(@ModelAttribute Chore chore, Model model) {
		crepository.save(chore);
		model.addAttribute("chores", crepository.findAll());
	    return "redirect:/chores";
	}
	
	@GetMapping("/deletechore/{id}")
	public String deleteChore(@PathVariable("id") String choreId, Model model) {
		long id = Integer.parseInt(choreId);
		crepository.deleteById(id);
		model.addAttribute("chores", crepository.findAll());
		return "redirect:/chores";
	}
	
	@PostMapping("/markdonepage/{id}")
	public String markChoreDone(@PathVariable("id") String choreId,  Model model) {
		long id = Integer.parseInt(choreId);
		 Chore doneChore = crepository.findById(id).get();
		 doneChore.setIsDone(true);
		 crepository.save(doneChore);
		 model.addAttribute("chores", crepository.findAll());
		return "redirect:/chores";
		
	}
	
}

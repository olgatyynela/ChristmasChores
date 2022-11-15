package com.example.ChristmasChores.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Chore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String askare;
	private boolean isDone; 
	
	 @ManyToOne
	 @JoinColumn(name = "tekijaId")
	 private Tekija tekija;
	
	public Chore() {}
	
	public Chore(String askare, boolean isDone) {
		this.askare = askare;
		this.isDone = isDone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Tekija getTekija() {
		return tekija;
	}

	public void setTekija(Tekija tekija) {
		this.tekija = tekija;
	}

	public String getAskare() {
		return askare;
	}

	public void setAskare(String askare) {
		this.askare = askare;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}

}

package com.example.ChristmasChores.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tekija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tekijaId;
	private String nimi;
	
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tekija")
    private List<Chore> chores;
	
	public Tekija() {}
	
	public Tekija(String nimi) {
		this.nimi = nimi;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public long getTekijaId() {
		return tekijaId;
	}

	public void setTekijaId(long tekijaId) {
		this.tekijaId = tekijaId;
	}
}

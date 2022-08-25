package com.kanaryahaber.abdlkdrkya.entities.concretes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oyuncular")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "oyuncuMaclari"})
public class Oyuncular extends OyuncularBase{
	
	@Column(name = "oyuncu_ayak")
	private String oyuncuAyak;
	
	@OneToMany(mappedBy = "oyuncu")
    Set<OyuncuMaclari> oyuncuMaclari;

}

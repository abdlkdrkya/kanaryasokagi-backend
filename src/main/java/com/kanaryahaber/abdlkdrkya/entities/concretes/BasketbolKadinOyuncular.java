package com.kanaryahaber.abdlkdrkya.entities.concretes;
import java.util.Set;


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
@Table(name = "kadin_basketbol_oyuncular")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "oyuncuMaclari"})
public class BasketbolKadinOyuncular extends OyuncularBase{

	@OneToMany(mappedBy = "oyuncu")
    Set<BasketbolKadinOyuncuMaclari> oyuncuMaclari;
}

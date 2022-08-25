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
@Table(name = "erkek_basketbol_oyuncular")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "oyuncuMaclari"})
public class BasketbolErkekOyuncular extends OyuncularBase{

	@OneToMany(mappedBy = "oyuncu")
    Set<BasketbolErkekOyuncuMaclari> oyuncuMaclari;
}

package com.kanaryahaber.abdlkdrkya.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "kadin_basketbol_oyuncu_maclari")
public class BasketbolKadinOyuncuMaclari extends BasketbolOyuncuMaclariBase{

	 @ManyToOne
	 @JoinColumn(name = "oyuncu_id")
	 BasketbolKadinOyuncular oyuncu;
	 
	 @ManyToOne
	 @JoinColumn(name = "mac_id")
	 Fikstur mac;

}

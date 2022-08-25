package com.kanaryahaber.abdlkdrkya.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "oyuncu_maclari")
public class OyuncuMaclari {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "mac_ilk11")
	private boolean macIlk11;

	@Column(name = "mac_dakika")
	private int macDakika;

	@Column(name = "mac_sarikart")
	private int macSariKart;

	@Column(name = "mac_kirmizikart")
	private int macKirmiziKart;

	@Column(name = "mac_gol")
	private int macGol;

	@Column(name = "mac_asist")
	private int macAsist;

	@ManyToOne
	@JoinColumn(name = "oyuncu_id")
	Oyuncular oyuncu;

	@ManyToOne
	@JoinColumn(name = "mac_id")
	Fikstur mac;

}

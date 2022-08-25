package com.kanaryahaber.abdlkdrkya.entities.concretes;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class OyuncularBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oyuncu_id")
	private int oyuncuId;
	
	@Column(name = "oyuncu_adi")
	private String oyuncuAdi;
	
	@Column(name = "oyuncu_soyadi")
	private String oyuncuSoyAdi;
	
	@Column(name = "oyuncu_mevki")
	private String oyuncuMevki;
	
	@Column(name = "oyuncu_yasi")
	private int oyuncuYasi;
	
	@Column(name = "oyuncu_uyruk")
	private String oyuncuUyruk;

	@Column(name = "oyuncu_boy")
	private double oyuncuBoy;
	
	@Column(name = "oyuncu_forma_numarasi")
	private int oyuncuFormaNumarasi;

	@Column(name = "oyuncu_profil")
	private String oyuncuProfil;


}

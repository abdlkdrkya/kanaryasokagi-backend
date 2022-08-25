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
public class BasketbolOyuncuMaclariBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "mac_sayi")
	private int macSayi;
	
	@Column(name = "mac_asist")
	private int macAsist;
	
	@Column(name = "mac_ribaund")
	private int macRibaund;
	
	@Column(name = "mac_top_calma")
	private int macTopCalma;
	
	@Column(name = "mac_blok")
	private int macBlok;
	
	@Column(name = "mac_hucum_ribaund")
	private int macHucumRibaund;

	@Column(name = "mac_savunma_ribaund")
	private int macSavunmaRibaund;
	
	@Column(name = "mac_top_kaybi")
	private int macTopKaybi;


}

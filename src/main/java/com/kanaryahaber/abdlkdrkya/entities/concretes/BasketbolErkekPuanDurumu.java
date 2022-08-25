package com.kanaryahaber.abdlkdrkya.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basketbol_erkek_puandurumu")
public class BasketbolErkekPuanDurumu extends PuanDurumuBase {
	@Column(name = "puan_durumu_atilan_sayi")
	private int atilanSayi;
	@Column(name = "puan_durumu_yenilen_sayi")
	private int yenilenSayi;
	@Column(name = "puan_durumu_averaj")
	private int averaj;
	@Column(name = "puan_durumu_logo")
	private String logo;
	
}

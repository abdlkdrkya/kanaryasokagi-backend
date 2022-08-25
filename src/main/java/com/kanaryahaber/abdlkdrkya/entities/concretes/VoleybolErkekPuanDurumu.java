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
@Table(name="voleybol_erkek_puan_durumu")
public class VoleybolErkekPuanDurumu extends PuanDurumuBase {
	@Column(name = "puan_durumu_aldigi_set")
	private int aldigiSet;
	@Column(name = "puan_durumu_verdigi_set")
	private int verdigiSet;
	@Column(name = "puan_durumu_set_averaji")
	private double setAveraji;
	@Column(name = "puan_durumu_aldigi_sayi")
	private int aldigiSayi;
	@Column(name = "puan_durumu_averaj")
	private double averaj;
	@Column(name = "puan_durumu_verdigi_sayi")
	private int verdigiSayi;
	@Column(name = "puan_durumu_logo")
	private String logo;
	
}

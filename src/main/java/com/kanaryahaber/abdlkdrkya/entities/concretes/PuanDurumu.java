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
@Table(name="puan_durumu")
public class PuanDurumu extends PuanDurumuBase{
	@Column(name = "puan_durumu_beraberlik")
	private int beraberlik;
	@Column(name = "puan_durumu_atilan_gol")
	private int atilanGol;
	@Column(name = "puan_durumu_yenilen_gol")
	private int yenilenGol;
	@Column(name = "puan_durumu_averaj")
	private int averaj;
	@Column(name = "puan_durumu_logo")
	private String logo;
	

}

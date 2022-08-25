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
public class PuanDurumuBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "puan_durumu_id")
	private int puanDurumuId;
	@Column(name = "puan_durumu_takim")
	private String takim;
	@Column(name = "puan_durumu_oynanan_mac")
	private int oynananMac;
	@Column(name = "puan_durumu_galibiyet")
	private int galibiyet;
	@Column(name = "puan_durumu_maglubiyet")
	private int maglubiyet;
	
	@Column(name = "puan_durumu_puan")
	private int puan;
}

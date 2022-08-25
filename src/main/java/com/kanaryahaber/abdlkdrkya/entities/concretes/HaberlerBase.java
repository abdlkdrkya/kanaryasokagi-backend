package com.kanaryahaber.abdlkdrkya.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
public class HaberlerBase {
	@Id
	@Column(name = "haber_id")
	private int haberId;
	@Column(name = "haber_baslik")
	private String haberBaslik;
	@Column(name = "haber_kaynak")
	private String haberKaynak;
	@Column(name = "haber_tarih")
	private LocalDate haberTarih;
	@Column(name = "haber_anasayfa_resim")
	private String haberAnasayfaResim;
	@Column(name = "haber_etiket_1")
	private String haberEtiket1;
	@Column(name = "haber_etiket_2")
	private String haberEtiket2;

	@ManyToOne
	@JoinColumn(name = "haber_kategori")
	private Kategori haberKategori;

}

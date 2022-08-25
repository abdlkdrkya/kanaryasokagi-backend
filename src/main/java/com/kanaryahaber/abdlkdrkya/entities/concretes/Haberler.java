package com.kanaryahaber.abdlkdrkya.entities.concretes;

import java.time.ZonedDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "haberler")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "userComments" })
public class Haberler{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "haber_id")
	private int haberId;
	@Column(name = "haber_baslik")
	private String haberBaslik;
	@Column(name = "haber_kaynak")
	private String haberKaynak;
	@Column(name = "haber_tarih")
	private ZonedDateTime haberTarih;
	@Column(name = "haber_anasayfa_resim")
	private String haberAnasayfaResim;
	@Column(name = "haber_etiket_1")
	private String haberEtiket1;
	@Column(name = "haber_etiket_2")
	private String haberEtiket2;
	@Column(name = "haber_like")
	private int haberLike;
	@Column(name = "haber_dislike")
	private int haberDislike;
	@Column(name = "haber_hate")
	private int haberHate;
	@Column(name = "haber_funny")
	private int haberFunny;
	@ManyToOne
	@JoinColumn(name = "haber_kategori")
	private Kategori haberKategori;
	@ManyToOne
	@JoinColumn(name = "haber_cinsiyet")
	private KategoriCinsiyet haberCinsiyet;
	
	@Column(name = "haber_icerik")
	private String haberIcerik;
	
	@OneToMany(mappedBy = "haber")
	Set<UserComments> userComments;

}

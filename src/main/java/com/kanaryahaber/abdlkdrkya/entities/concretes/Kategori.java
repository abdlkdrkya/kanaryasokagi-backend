package com.kanaryahaber.abdlkdrkya.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "haber_kategori")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "haberler"})
public class Kategori {
	@Id
	@Column(name = "kategori_id")
	private int kategoriId;
	@Column(name="kategori_ad")
	private String kategoriAd;
	@Column(name="kategori_aciklama")
	private String kategoriAciklama;
	
	@OneToMany(mappedBy = "haberKategori")
	private List<Haberler> haberler;
}

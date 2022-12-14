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
@Table(name = "kategori_cinsiyet")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "haberler"})
public class KategoriCinsiyet {
	
	@Id
	@Column(name = "cinsiyet_id")
	private int cinsiyetId;
	
	@Column(name = "cinsiyet_adi")
	private String cinsiyetAdi;
	
	@OneToMany(mappedBy = "haberCinsiyet")
	private List<Haberler> haberler;

}

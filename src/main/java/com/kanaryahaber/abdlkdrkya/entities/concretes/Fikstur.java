package com.kanaryahaber.abdlkdrkya.entities.concretes;

import java.time.LocalDate;
import java.util.Objects;
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
@Table(name = "fikstur")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "oyuncuMaclari"})
public class Fikstur{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fikstur_id")
	private int fiksturId;
	@Column(name = "fikstur_tarih")
	private LocalDate fiksturTarih;
	
	@Column(name = "fikstur_evsahibi")
	private String fiksturEvSahibi;
	
	@Column(name = "fikstur_deplasman")
	private String fiksturDeplasman;
	
	@Column(name = "fikstur_evsahibi_skor")
	private String fiksturEvSahibiSkor;
	
	@Column(name = "fikstur_evsahibi_ilkperiyot_skor")
	private String fiksturEvSahibiIlkPeriyotSkor;
	
	@Column(name = "fikstur_evsahibi_ikinciperiyot_skor")
	private String fiksturEvSahibiIkinciPeriyotSkor;
	
	@Column(name = "fikstur_evsahibi_ucuncuperiyot_skor")
	private String fiksturEvSahibiUcuncuPeriyotSkor;
	
	@Column(name = "fikstur_evsahibi_dorduncuperiyot_skor")
	private String fiksturEvSahibiDorduncuPeriyotSkor;
	
	@Column(name = "fikstur_evsahibi_besinciperiyot_skor")
	private String fiksturEvSahibiBesinciPeriyotSkor;
	
	@Column(name = "fikstur_evsahibi_ilkyari_skor")
	private String fiksturEvSahibiIlkYariSkor;
	
	@Column(name = "fikstur_evsahibi_ilkceyrek_skor")
	private String fiksturEvSahibiIlkCeyrekSkor;
	
	@Column(name = "fikstur_evsahibi_ikinciceyrek_skor")
	private String fiksturEvSahibiIkinciCeyrekSkor;
	
	@Column(name = "fikstur_evsahibi_ucuncuceyrek_skor")
	private String fiksturEvSahibiUcuncuCeyrekSkor;
	
	@Column(name = "fikstur_evsahibi_dorduncuceyrek_skor")
	private String fiksturEvSahibiDorduncuCeyrekSkor;
	
	@Column(name = "fikstur_deplasman_skor")
	private String fiksturDeplasmanSkor;
	
	@Column(name = "fikstur_deplasman_ilkperiyot_skor")
	private String fiksturDeplasmanIlkPeriyotSkor;
	
	@Column(name = "fikstur_deplasman_ikinciperiyot_skor")
	private String fiksturDeplasmanIkinciPeriyotSkor;
	
	@Column(name = "fikstur_deplasman_ucuncuperiyot_skor")
	private String fiksturDeplasmanUcuncuPeriyotSkor;
	
	@Column(name = "fikstur_deplasman_dorduncuperiyot_skor")
	private String fiksturDeplasmanDorduncuPeriyotSkor;
	
	@Column(name = "fikstur_deplasman_besinciperiyot_skor")
	private String fiksturDeplasmanBesinciPeriyotSkor;
	
	@Column(name = "fikstur_deplasman_ilkyari_skor")
	private String fiksturDeplasmanIlkYariSkor;
	
	@Column(name = "fikstur_deplasman_ilkceyrek_skor")
	private String fiksturDeplasmanIlkCeyrekSkor;
	
	@Column(name = "fikstur_deplasman_ikinciceyrek_skor")
	private String fiksturDeplasmanIkinciCeyrekSkor;
	
	@Column(name = "fikstur_deplasman_ucuncuceyrek_skor")
	private String fiksturDeplasmanUcuncuCeyrekSkor;
	
	@Column(name = "fikstur_deplasman_dorduncuceyrek_skor")
	private String fiksturDeplasmanDorduncuCeyrekSkor;
	
	@Column(name = "fikstur_turnuva")
	private String fiksturTurnuva;
	
	@Column(name = "fikstur_evsahibi_logo")
	private String fiksturEvSahibiLogo;

	@Column(name = "fikstur_deplasman_logo")
	private String fiksturDeplasmanLogo;
	
	@OneToMany(mappedBy = "mac")
    Set<OyuncuMaclari> oyuncuMaclari;
	
	@ManyToOne
	@JoinColumn(name = "fikstur_kategori")
	private FiksturKategori fiksturKategori;
		
	
	@ManyToOne
	@JoinColumn(name = "fikstur_cinsiyet")
	private FiksturCinsiyet fiksturCinsiyet;
}

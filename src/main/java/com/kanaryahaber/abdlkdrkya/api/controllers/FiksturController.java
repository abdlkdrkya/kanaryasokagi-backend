package com.kanaryahaber.abdlkdrkya.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kanaryahaber.abdlkdrkya.business.abstracts.FiksturService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Fikstur;

@RestController
@RequestMapping("/api/fikstur")
@CrossOrigin
public class FiksturController {

	private FiksturService fiksturService;

	@Autowired
	public FiksturController(FiksturService fiksturService) {
		super();
		this.fiksturService = fiksturService;
	}

	@PostMapping("/fikstur-ekle")
	public Result addFutbolErkek(@RequestParam String fiksturDeplasman, String fiksturDeplasmanSkor,
			@RequestParam String fiksturEvSahibi, String fiksturEvSahibiSkor, @RequestParam String fiksturTarih,
			@RequestParam String fiksturTurnuva, @RequestParam int fiksturKategoriId,
			@RequestParam int fiksturCinsiyetId) {
		return this.fiksturService.add(fiksturDeplasman, fiksturDeplasmanSkor, fiksturEvSahibi, fiksturEvSahibiSkor,
				fiksturTarih, fiksturTurnuva, fiksturKategoriId, fiksturCinsiyetId);
	}

	@GetMapping("/fikstur-sirali-getir")
	public DataResult<List<Fikstur>> fiksturSirala(@RequestParam int fiksturKategoriId,
			@RequestParam int fiksturCinsiyetId) {
		return this.fiksturService.fiksturSirala(fiksturKategoriId, fiksturCinsiyetId);

	}

	@GetMapping("/fikstur-tumunu-getir")
	public DataResult<List<Fikstur>> fiksturTumunuGetir(@RequestParam int fiksturKategoriId,
			@RequestParam int fiksturCinsiyetId) {
		return this.fiksturService.fiksturTumunuGetir(fiksturKategoriId, fiksturCinsiyetId);
	}

	@PatchMapping("/guncelle")
	public Result skorEkle(String fiksturEvSahibiSkor, String fiksturEvSahibiIlkPeriyotSkor,
			String fiksturEvSahibiIkinciPeriyotSkor, String fiksturEvSahibiUcuncuPeriyotSkor,
			String fiksturEvSahibiDorduncuPeriyotSkor, String fiksturEvSahibiBesinciPeriyotSkor,
			String fiksturEvSahibiIlkYariSkor, String fiksturEvSahibiIlkCeyrekSkor,
			String fiksturEvSahibiIkinciCeyrekSkor, String fiksturEvSahibiUcuncuCeyrekSkor,
			String fiksturEvSahibiDorduncuCeyrekSkor, String fiksturDeplasmanSkor,
			String fiksturDeplasmanIlkPeriyotSkor, String fiksturDeplasmanIkinciPeriyotSkor,
			String fiksturDeplasmanUcuncuPeriyotSkor, String fiksturDeplasmanDorduncuPeriyotSkor,
			String fiksturDeplasmanBesinciPeriyotSkor, String fiksturDeplasmanIlkYariSkor,
			String fiksturDeplasmanIlkCeyrekSkor, String fiksturDeplasmanIkinciCeyrekSkor,
			String fiksturDeplasmanUcuncuCeyrekSkor, String fiksturDeplasmanDorduncuCeyrekSkor, String fiksturTarih, int fiksturId) {
		return this.fiksturService.skorEkle(fiksturEvSahibiSkor, fiksturEvSahibiIlkPeriyotSkor,
				fiksturEvSahibiIkinciPeriyotSkor, fiksturEvSahibiUcuncuPeriyotSkor, fiksturEvSahibiDorduncuPeriyotSkor,
				fiksturEvSahibiBesinciPeriyotSkor, fiksturEvSahibiIlkYariSkor, fiksturEvSahibiIlkCeyrekSkor,
				fiksturEvSahibiIkinciCeyrekSkor, fiksturEvSahibiUcuncuCeyrekSkor, fiksturEvSahibiDorduncuCeyrekSkor,
				fiksturDeplasmanSkor, fiksturDeplasmanIlkPeriyotSkor, fiksturDeplasmanIkinciPeriyotSkor,
				fiksturDeplasmanUcuncuPeriyotSkor, fiksturDeplasmanDorduncuPeriyotSkor,
				fiksturDeplasmanBesinciPeriyotSkor, fiksturDeplasmanIlkYariSkor, fiksturDeplasmanIlkCeyrekSkor,
				fiksturDeplasmanIkinciCeyrekSkor, fiksturDeplasmanUcuncuCeyrekSkor, fiksturDeplasmanDorduncuCeyrekSkor, fiksturTarih,
				fiksturId);
	}

}

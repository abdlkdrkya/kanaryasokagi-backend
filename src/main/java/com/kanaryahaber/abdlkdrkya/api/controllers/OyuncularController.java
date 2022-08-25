package com.kanaryahaber.abdlkdrkya.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kanaryahaber.abdlkdrkya.business.abstracts.OyuncularService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Oyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolErkekOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolKadinOyuncular;

@RestController
@RequestMapping("/api/oyuncular")
@CrossOrigin
public class OyuncularController {

	private OyuncularService oyuncularService;

	@Autowired
	public OyuncularController(OyuncularService oyuncularService) {
		super();
		this.oyuncularService = oyuncularService;
	}

	@GetMapping("/futbol-erkek-getir")
	public DataResult<List<Oyuncular>> erkekFutbolGetir() {
		return this.oyuncularService.erkekFutbolGetir();
	}
	
	@GetMapping("/basketbol-erkek-getir")
	public DataResult<List<BasketbolErkekOyuncular>> erkekBasketbolOyunculariGetir() {
		return this.oyuncularService.erkekBasketbolOyunculariGetir();
	}
	
	@GetMapping("/futbol-erkek-getir-byId")
	public DataResult<Oyuncular> erkekFutbolGetirByOyuncuId(int oyuncuId){
		return this.oyuncularService.erkekFutbolGetirByOyuncuId(oyuncuId);
	}
	
	@GetMapping("/basketbol-erkek-getir-byId")
	public DataResult<BasketbolErkekOyuncular> erkekBasketbolGetirByOyuncuId(int oyuncuId){
		return this.oyuncularService.erkekBasketbolGetirByOyuncuId(oyuncuId);
	}
	
	@GetMapping("/basketbol-kadin-getir-byId")
	public DataResult<BasketbolKadinOyuncular> kadinBasketbolGetirByOyuncuId(int oyuncuId){
		return this.oyuncularService.kadinBasketbolGetirByOyuncuId(oyuncuId);
	}

	@GetMapping("/basketbol-kadin-getir")
	public DataResult<List<BasketbolKadinOyuncular>> kadinBasketbolOyunculariGetir() {
		return this.oyuncularService.kadinBasketbolOyunculariGetir();
	}

	@GetMapping("/voleybol-erkek-getir")
	public DataResult<List<VoleybolErkekOyuncular>> erkekVoleybolOyunculariGetir() {
		return this.oyuncularService.erkekVoleybolOyunculariGetir();
	}

	@GetMapping("/voleybol-kadin-getir")
	public DataResult<List<VoleybolKadinOyuncular>> kadinVoleybolOyunculariGetir() {
		return this.oyuncularService.kadinVoleybolOyunculariGetir();
	}
	
	@PostMapping("/futbol-erkek-ekle")
	public Result addFutbolErkek(@RequestParam String oyuncuAdi, @RequestParam String oyuncuSoyAdi,
			@RequestParam String oyuncuUyruk, @RequestParam String oyuncuMevki, @RequestParam String oyuncuProfil,
			@RequestParam int oyuncuYasi, @RequestParam int oyuncuFormaNumarasi, @RequestParam double oyuncuBoyu) {
		return this.oyuncularService.addFutbolErkek(oyuncuAdi, oyuncuSoyAdi, oyuncuUyruk, oyuncuMevki, oyuncuProfil, oyuncuYasi,
				oyuncuFormaNumarasi, oyuncuBoyu);
	}
	
	@PostMapping("/basketbol-erkek-ekle")
	public Result addBasketbolErkek(@RequestParam String oyuncuAdi, @RequestParam String oyuncuSoyAdi,
			@RequestParam String oyuncuUyruk, @RequestParam String oyuncuMevki, @RequestParam String oyuncuProfil,
			@RequestParam int oyuncuYasi, @RequestParam int oyuncuFormaNumarasi, @RequestParam double oyuncuBoyu) {
		return this.oyuncularService.addBasketbolErkek(oyuncuAdi, oyuncuSoyAdi, oyuncuUyruk, oyuncuMevki, oyuncuProfil, oyuncuYasi,
				oyuncuFormaNumarasi, oyuncuBoyu);
	}
	
	@PostMapping("/basketbol-kadin-ekle")
	public Result addBasketbolKadin(@RequestParam String oyuncuAdi, @RequestParam String oyuncuSoyAdi,
			@RequestParam String oyuncuUyruk, @RequestParam String oyuncuMevki, @RequestParam String oyuncuProfil,
			@RequestParam int oyuncuYasi, @RequestParam int oyuncuFormaNumarasi, @RequestParam double oyuncuBoyu) {
		return this.oyuncularService.addBasketbolKadin(oyuncuAdi, oyuncuSoyAdi, oyuncuUyruk, oyuncuMevki, oyuncuProfil, oyuncuYasi,
				oyuncuFormaNumarasi, oyuncuBoyu);
	}

	@PostMapping("/voleybol-erkek-ekle")
	public Result addVoleybolErkek(@RequestParam String oyuncuAdi, @RequestParam String oyuncuSoyAdi,
			@RequestParam String oyuncuUyruk, @RequestParam String oyuncuMevki, @RequestParam String oyuncuProfil,
			@RequestParam int oyuncuYasi, @RequestParam int oyuncuFormaNumarasi, @RequestParam double oyuncuBoyu) {
		return this.oyuncularService.addVoleybolErkek(oyuncuAdi, oyuncuSoyAdi, oyuncuUyruk, oyuncuMevki, oyuncuProfil, oyuncuYasi,
				oyuncuFormaNumarasi, oyuncuBoyu);
	}
	
	@PostMapping("/voleybol-kadin-ekle")
	public Result addVoleybolKadin(@RequestParam String oyuncuAdi, @RequestParam String oyuncuSoyAdi,
			@RequestParam String oyuncuUyruk, @RequestParam String oyuncuMevki, @RequestParam String oyuncuProfil,
			@RequestParam int oyuncuYasi, @RequestParam int oyuncuFormaNumarasi, @RequestParam double oyuncuBoyu) {
		return this.oyuncularService.addVoleybolKadin(oyuncuAdi, oyuncuSoyAdi, oyuncuUyruk, oyuncuMevki, oyuncuProfil, oyuncuYasi,
				oyuncuFormaNumarasi, oyuncuBoyu);
	}
}

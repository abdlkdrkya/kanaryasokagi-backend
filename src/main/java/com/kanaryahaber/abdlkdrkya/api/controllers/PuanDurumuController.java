package com.kanaryahaber.abdlkdrkya.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kanaryahaber.abdlkdrkya.business.abstracts.PuanDurumuService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekPuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinPuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.PuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolErkekPuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolKadinPuanDurumu;



@RestController
@RequestMapping("api/puandurumu")
@CrossOrigin
public class PuanDurumuController {

	private PuanDurumuService puanDurumuService;
	
	@Autowired
	public PuanDurumuController(PuanDurumuService puanDurumuService) {
		super();
		this.puanDurumuService = puanDurumuService;
	}
	
	@PostMapping("/puandurumu-ekle")
	public Result addPuanDurumu(@RequestParam String takimAdi, @RequestParam int galibiyet,@RequestParam int beraberlik,@RequestParam int maglubiyet,@RequestParam int atilanGol,@RequestParam int yenilenGol) {
		return this.puanDurumuService.addPuanDurumu(takimAdi,galibiyet, beraberlik, maglubiyet, atilanGol, yenilenGol);
	}
	
	@PostMapping("/puandurumuguncelle")
	public Result updatePuanDurumu(@RequestParam int takimId,@RequestParam int galibiyet,@RequestParam int beraberlik,@RequestParam int maglubiyet,
			@RequestParam int atilanGol,@RequestParam int yenilenGol) {
		return this.puanDurumuService.updatePuanDurumu(takimId, galibiyet, beraberlik, maglubiyet, atilanGol, yenilenGol);
	}
	
	@GetMapping("/puandurumugetir")
	public DataResult<List<PuanDurumu>> getAllSorted(){
		return this.puanDurumuService.getAllSorted();
	}
	
	@PostMapping("/basketbol-erkek-puandurumu-ekle")
	public Result addPuanDurumuErkek(@RequestParam String takimAdi, @RequestParam int galibiyet,@RequestParam int maglubiyet,@RequestParam int atilanSayi,@RequestParam int yenilenSayi) {
		return this.puanDurumuService.addPuanDurumuBasketbolErkek(takimAdi,galibiyet, maglubiyet, atilanSayi, yenilenSayi);
	}
	
	@PostMapping("/basketbol-erkek-puandurumu-guncelle")
	public Result updateBasketbolErkekPuanDurumu(@RequestParam int takimId,@RequestParam int galibiyet,@RequestParam int maglubiyet,@RequestParam int atilanSayi,@RequestParam int yenilenSayi) {
		return this.puanDurumuService.updateBasketbolErkekPuanDurumu(takimId, galibiyet, maglubiyet, atilanSayi, yenilenSayi);
	}
	
	@GetMapping("/basketbol-erkek-puandurumu-getir")
	public DataResult<List<BasketbolErkekPuanDurumu>> getAllSortedBasketbolErkek() {
		return this.puanDurumuService.getAllSortedBasketbolErkek();
	}
	
	@PostMapping("/basketbol-kadin-puandurumu-ekle")
	public Result addPuanDurumuKadin(@RequestParam String takimAdi, @RequestParam int galibiyet,@RequestParam int maglubiyet,@RequestParam int atilanSayi,@RequestParam int yenilenSayi) {
		return this.puanDurumuService.addPuanDurumuBasketbolKadin(takimAdi, galibiyet, maglubiyet, atilanSayi, yenilenSayi);
	}
	
	@PostMapping("/basketbol-kadin-puandurumu-guncelle")
	public Result updateBasketbolKadinPuanDurumu(@RequestParam int takimId,@RequestParam int galibiyet,@RequestParam int maglubiyet,@RequestParam int atilanSayi,@RequestParam int yenilenSayi) {
		return this.puanDurumuService.updateBasketbolKadinPuanDurumu(takimId, galibiyet, maglubiyet, atilanSayi, yenilenSayi);
	}
	
	@GetMapping("/basketbol-kadin-puandurumu-getir")
	public DataResult<List<BasketbolKadinPuanDurumu>> getAllSortedBasketbolKadin() {
		return this.puanDurumuService.getAllSortedBasketbolKadin();
	}
	
	@PostMapping("/voleybol-kadin-puandurumu-ekle")
	public Result addPuanDurumuKadinVoleybol(@RequestParam String takimAdi,@RequestParam int galibiyet,@RequestParam int maglubiyet,
			@RequestParam int atilanSayi,@RequestParam int yenilenSayi,@RequestParam int aldigiSet,@RequestParam int verdigiSet,@RequestParam int puan) {
		return this.puanDurumuService.addPuanDurumuVoleybolKadin(takimAdi, galibiyet, maglubiyet, atilanSayi,
				yenilenSayi, aldigiSet, verdigiSet, puan);
	}
	
	@PostMapping("/voleybol-kadin-puandurumu-guncelle")
	public Result updateVoleybolKadinPuanDurumu(@RequestParam int takimId,@RequestParam int galibiyet,
			@RequestParam int maglubiyet,@RequestParam int atilanSayi,@RequestParam int yenilenSayi,@RequestParam int aldigiSet,
			@RequestParam int verdigiSet,@RequestParam int puan) {
		return this.puanDurumuService.updateVoleybolKadinPuanDurumu(takimId,galibiyet,maglubiyet, atilanSayi,
				yenilenSayi, aldigiSet, verdigiSet, puan);
	}
	
	@GetMapping("/voleybol-kadin-puandurumu-getir")
	public DataResult<List<VoleybolKadinPuanDurumu>> getAllSortedVoleybolKadin() {
		return this.puanDurumuService.getAllSortedVoleybolKadin();
	}
	
	@PostMapping("/voleybol-erkek-puandurumu-ekle")
	public Result addPuanDurumuErkekVoleybol(@RequestParam String takimAdi,@RequestParam int galibiyet,@RequestParam int maglubiyet,
			@RequestParam int atilanSayi,@RequestParam int yenilenSayi,@RequestParam int aldigiSet,@RequestParam int verdigiSet,@RequestParam int puan) {
		return this.puanDurumuService.addPuanDurumuVoleybolErkek(takimAdi, galibiyet, maglubiyet, atilanSayi,
				yenilenSayi, aldigiSet, verdigiSet, puan);
	}
	
	@PostMapping("/voleybol-erkek-puandurumu-guncelle")
	public Result updateVoleybolErkekPuanDurumu(@RequestParam int takimId,@RequestParam int galibiyet,
			@RequestParam int maglubiyet,@RequestParam int atilanSayi,@RequestParam int yenilenSayi,@RequestParam int aldigiSet,
			@RequestParam int verdigiSet,@RequestParam int puan) {
		return this.puanDurumuService.updateVoleybolErkekPuanDurumu(takimId,galibiyet,maglubiyet, atilanSayi,
				yenilenSayi, aldigiSet, verdigiSet, puan);
	}
	
	@GetMapping("/voleybol-erkek-puandurumu-getir")
	public DataResult<List<VoleybolErkekPuanDurumu>> getAllSortedVoleybolErkek() {
		return this.puanDurumuService.getAllSortedVoleybolErkek();
	}
}

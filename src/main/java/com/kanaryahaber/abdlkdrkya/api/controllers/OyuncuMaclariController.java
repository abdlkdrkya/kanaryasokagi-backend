package com.kanaryahaber.abdlkdrkya.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kanaryahaber.abdlkdrkya.business.abstracts.OyuncuMaclariService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekOyuncuMaclari;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinOyuncuMaclari;
import com.kanaryahaber.abdlkdrkya.entities.concretes.OyuncuMaclari;


@RestController
@RequestMapping("/api/oyuncu-maclari")
@CrossOrigin
public class OyuncuMaclariController {

	private OyuncuMaclariService oyuncuMaclariService;
	
	public OyuncuMaclariController(OyuncuMaclariService oyuncuMaclariService) {
		super();
		this.oyuncuMaclariService = oyuncuMaclariService;
	}
	
	@PostMapping("/erkek-futbol-ekle")
	public Result add(@RequestParam int macOyuncuId,@RequestParam boolean macIlk11,@RequestParam int macDakika,@RequestParam int macSariKart,
			@RequestParam int macKirmiziKart,@RequestParam int macGol,
			@RequestParam int macAsist, @RequestParam int macId) {
		return this.oyuncuMaclariService.add(macOyuncuId,macIlk11,
				macDakika,macSariKart,macKirmiziKart,macGol,
				macAsist,macId);
	}
	
	@PatchMapping("/erkek-futbol-guncelle")
	public Result futbolcuGuncelle(int macOyuncuId, boolean macIlk11, int macDakika, int macSariKart, int macKirmiziKart, int macGol,
			int macAsist, int macId) {
		return this.oyuncuMaclariService.futbolcuGuncelle(macOyuncuId,macIlk11,
				macDakika,macSariKart,macKirmiziKart,macGol,
				macAsist,macId);
	}
	
	@GetMapping("/erkek-futbol-oyuncuya-gore-getir")
	public DataResult<List<OyuncuMaclari>> oyuncuMaclariGetirByOyuncuId(@RequestParam int oyuncuId){
		return this.oyuncuMaclariService.oyuncuMaclariGetirByOyuncuId(oyuncuId);
	}
	
	@GetMapping("/erkek-futbol-fiksture-gore-getir")
	public DataResult<List<OyuncuMaclari>> oyuncuMaclariGetirByFiksturId(int fiksturId){
		return this.oyuncuMaclariService.oyuncuMaclariGetirByFiksturId(fiksturId);	
	}
	
	@GetMapping("/erkek-futbol-getAll")
	public DataResult<List<OyuncuMaclari>> getAll() {
		return this.oyuncuMaclariService.getAll();
	}
	
	
	
	@PostMapping("/erkek-basketbol-ekle")
	public Result addBasketbolErkekOyuncuMaci(@RequestParam int macOyuncuId,@RequestParam int macAsist,@RequestParam int macBlock,@RequestParam int macHucumRibaund,
			@RequestParam int macSavunmaRibaund,@RequestParam int macSayi,@RequestParam int macTopCalma,@RequestParam int macTopKaybi,@RequestParam int macId) {
		return this.oyuncuMaclariService.addBasketbolErkekOyuncuMaci(macOyuncuId, macAsist, macBlock, macHucumRibaund, macSavunmaRibaund,macSayi,macTopCalma, macTopKaybi, macId);
	}
	
	@PatchMapping("/erkek-basketbol-guncelle")
	public Result guncelleBasketbolErkekOyuncuMaci(int macOyuncuId, int macAsist, int macBlock, int macHucumRibaund, int macSavunmaRibaund,int macSayi,int macTopCalma,
			int macTopKaybi,int macId) {
		return this.oyuncuMaclariService.guncelleBasketbolErkekOyuncuMaci(macOyuncuId, macAsist, macBlock, macHucumRibaund, macSavunmaRibaund,macSayi,macTopCalma, macTopKaybi, macId);
	}
	
	@GetMapping("/erkek-basketbol--oyuncuya-gore-getir")
	public DataResult<List<BasketbolErkekOyuncuMaclari>> basketbolErkekOyuncuMaclariGetirByOyuncuId(@RequestParam int oyuncuId){
		return this.oyuncuMaclariService.basketbolErkekOyuncuMaclariGetirByOyuncuId(oyuncuId);
	}
	
	@GetMapping("/erkek-basketbol--fiksture-gore-getir")
	public DataResult<List<BasketbolErkekOyuncuMaclari>> basketbolErkekOyuncuMaclariGetirByFiksturId(int fiksturId){
		return this.oyuncuMaclariService.basketbolErkekOyuncuMaclariGetirByFiksturId(fiksturId);	
	}
	
	@GetMapping("/erkek-basketbol-getAll")
	public DataResult<List<BasketbolErkekOyuncuMaclari>> getAllBasketbolErkekOyuncuMaclari() {
		return this.oyuncuMaclariService.getAllBasketbolErkekOyuncuMaclari();
	}
	
	
	
	@PostMapping("/kadin-basketbol-ekle")
	public Result addBasketbolKadinOyuncuMaci(@RequestParam int macOyuncuId,@RequestParam int macAsist,@RequestParam int macBlock,@RequestParam int macHucumRibaund,
			@RequestParam int macSavunmaRibaund,@RequestParam int macSayi,@RequestParam int macTopCalma,@RequestParam int macTopKaybi,@RequestParam int macId) {
		return this.oyuncuMaclariService.addBasketbolKadinOyuncuMaci(macOyuncuId, macAsist, macBlock, macHucumRibaund, macSavunmaRibaund,macSayi,macTopCalma, macTopKaybi, macId);
	}
	
	@PatchMapping("/kadin-basketbol-guncelle")
	public Result guncelleBasketbolKadinOyuncuMaci(int macOyuncuId, int macAsist, int macBlock, int macHucumRibaund, int macSavunmaRibaund,int macSayi,int macTopCalma,
			int macTopKaybi,int macId) {
		return this.oyuncuMaclariService.guncelleBasketbolKadinOyuncuMaci(macOyuncuId, macAsist, macBlock, macHucumRibaund, macSavunmaRibaund,macSayi,macTopCalma, macTopKaybi, macId);
	}
	
	@GetMapping("/kadin-basketbol--oyuncuya-gore-getir")
	public DataResult<List<BasketbolKadinOyuncuMaclari>> basketbolKadinOyuncuMaclariGetirByOyuncuId(@RequestParam int oyuncuId){
		return this.oyuncuMaclariService.basketbolKadinOyuncuMaclariGetirByOyuncuId(oyuncuId);
	}
	
	@GetMapping("/kadin-basketbol--fiksture-gore-getir")
	public DataResult<List<BasketbolKadinOyuncuMaclari>> basketbolKadinOyuncuMaclariGetirByFiksturId(int fiksturId){
		return this.oyuncuMaclariService.basketbolKadinOyuncuMaclariGetirByFiksturId(fiksturId);	
	}
	
	@GetMapping("/kadin-basketbol-getAll")
	public DataResult<List<BasketbolKadinOyuncuMaclari>> getAllBasketbolKadinOyuncuMaclari() {
		return this.oyuncuMaclariService.getAllBasketbolKadinOyuncuMaclari();
	}
}

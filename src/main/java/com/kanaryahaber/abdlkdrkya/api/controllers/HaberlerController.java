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

import com.kanaryahaber.abdlkdrkya.business.abstracts.HaberService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Haberler;

@RestController
@RequestMapping("/api/haberler")
@CrossOrigin
public class HaberlerController {
	private HaberService haberService;

	@Autowired
	public HaberlerController(HaberService haberService) {
		super();
		this.haberService = haberService;
	}

	@GetMapping("/haberlerigetir")
	public DataResult<List<Haberler>> getAll() {
		return this.haberService.getAll();
	}
	
	@PatchMapping("/haberEtkilesim")
	public Result sosyalEtkilesim(int haberId, int etkilesimId) {
		return this.haberService.sosyalEtkilesim(haberId, etkilesimId);
	}

	@PostMapping("/add")
	public Result add(@RequestParam String haberBaslik, @RequestParam String haberIcerik, String haberKaynak,
			@RequestParam String haberAnasayfaResim, String haberEtiket1, String haberEtiket2,
			@RequestParam int haberKategoriId, @RequestParam int haberCinsiyetId) {
		return this.haberService.add(haberBaslik, haberIcerik, haberKaynak, haberAnasayfaResim, haberEtiket1,
				haberEtiket2, haberKategoriId, haberCinsiyetId);
	}
	
	@PatchMapping("/guncelle")
	public Result guncelle(@RequestParam int haberId, String haberBaslik, String haberIcerik, String haberKaynak,
			String haberAnasayfaResim, String haberEtiket1, String haberEtiket2,
			int haberKategoriId, int haberCinsiyetId) {
		return this.haberService.guncelle(haberId,haberBaslik, haberIcerik, haberKaynak, haberAnasayfaResim, haberEtiket1,
				haberEtiket2, haberKategoriId, haberCinsiyetId);
	}

	@GetMapping("/getByHaberBaslik")
	public DataResult<Haberler> getByHaberBaslik(@RequestParam String haberName) {
		return this.haberService.getByHaberBaslik(haberName);
	}

	@GetMapping("/getByHaberKategori")
	public DataResult<List<Haberler>> getByHaberKategori_KategoriId(@RequestParam int categoryId) {
		return this.haberService.getByHaberKategori_KategoriId(categoryId);
	}

	@GetMapping("/getByHaberKategoriSorted")
	public DataResult<List<Haberler>> getByHaberKategori_KategoriIdSorted(@RequestParam int categoryId) {
		return this.haberService.getByHaberKategori_KategoriIdSorted(categoryId);
	}

	@GetMapping("/getByHaberNameAndCategory")
	public DataResult<Haberler> getByHaberNameAndCategory(@RequestParam("haberName") String haberName,
			@RequestParam("categoryId") int categoryId) {
		return this.haberService.getByHaberBaslikAndKategori(haberName, categoryId);
	}

	@GetMapping("/getByHaberNameContains")
	public DataResult<List<Haberler>> getByHaberNameContains(String haberName) {
		return this.haberService.getByHaberBaslikContains(haberName);
	}

	@GetMapping("/getAllByPage")
	DataResult<List<Haberler>> getSondakika() {
		return this.haberService.getSondakika();
	}

	@GetMapping("/getAllAsc")
	public DataResult<List<Haberler>> getAllSorted() {
		return this.haberService.getAllSorted();
	}

	@GetMapping("/getByHaberId")
	public DataResult<Haberler> getByHaberId(int haberId) {
		return this.haberService.getByHaberId(haberId);
	}

	@GetMapping("/getByHaberKategoriAndCinsiyet")
	public DataResult<List<Haberler>> getByHaberKategori_KategoriIdAndHaberCinsiyet_CinsiyetId(int categoryId,
			int cinsiyetId) {
		return this.haberService.getByHaberKategori_KategoriIdAndHaberCinsiyet_CinsiyetId(categoryId, cinsiyetId);
	}

}

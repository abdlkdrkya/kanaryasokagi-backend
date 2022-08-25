package com.kanaryahaber.abdlkdrkya.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kanaryahaber.abdlkdrkya.business.abstracts.OyuncularService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessResult;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.BasketbolErkekOyuncularDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.BasketbolKadinOyuncularDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.OyuncularDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.VoleybolErkekOyuncularDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.VoleybolKadinOyuncularDao;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Oyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolErkekOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolKadinOyuncular;

@Service
public class OyuncularManager implements OyuncularService{

	private OyuncularDao oyuncularDao;
	private BasketbolErkekOyuncularDao basketbolErkekOyuncularDao;
	private BasketbolKadinOyuncularDao basketbolKadinOyuncularDao;
	private VoleybolErkekOyuncularDao voleybolErkekOyuncularDao;
	private VoleybolKadinOyuncularDao voleybolKadinOyuncularDao;
	
	@Autowired
	public OyuncularManager(OyuncularDao oyuncularDao,BasketbolErkekOyuncularDao basketbolErkekOyuncularDao,BasketbolKadinOyuncularDao basketbolKadinOyuncularDao,
			VoleybolErkekOyuncularDao voleybolErkekOyuncularDao, VoleybolKadinOyuncularDao voleybolKadinOyuncularDao) {
		super();
		this.basketbolErkekOyuncularDao = basketbolErkekOyuncularDao;
		this.basketbolKadinOyuncularDao = basketbolKadinOyuncularDao;
		this.voleybolErkekOyuncularDao = voleybolErkekOyuncularDao;
		this.voleybolKadinOyuncularDao = voleybolKadinOyuncularDao;
		this.oyuncularDao = oyuncularDao;
	}

	@Override
	public DataResult<List<Oyuncular>> erkekFutbolGetir() {
		Sort sort = Sort.by(Sort.Direction.ASC,"oyuncuId");
		return new SuccessDataResult<List<Oyuncular>>(this.oyuncularDao.findAll(sort));
	}

	@Override
	public DataResult<Oyuncular> erkekFutbolGetirByOyuncuId(int oyuncuId) {
		Oyuncular oyuncu = this.oyuncularDao.getByOyuncuId(oyuncuId);
		if(oyuncu == null) {
			return new ErrorDataResult<>(false,"Oyuncu bulunamadı");
		}
		return new SuccessDataResult<Oyuncular>(oyuncu);
	}
	
	@Override
	public DataResult<BasketbolErkekOyuncular> erkekBasketbolGetirByOyuncuId(int oyuncuId){
		BasketbolErkekOyuncular oyuncu = this.basketbolErkekOyuncularDao.getByOyuncuId(oyuncuId);
		if(oyuncu==null) {
			return new ErrorDataResult<>(false,"Oyuncu bulunamadı");
		}
		return new SuccessDataResult<BasketbolErkekOyuncular>(oyuncu);
	}
	
	@Override
	public DataResult<BasketbolKadinOyuncular> kadinBasketbolGetirByOyuncuId(int oyuncuId){
		BasketbolKadinOyuncular oyuncu = this.basketbolKadinOyuncularDao.getByOyuncuId(oyuncuId);
		if(oyuncu==null) {
			return new ErrorDataResult<>(false,"Oyuncu bulunamadı");
		}
		return new SuccessDataResult<BasketbolKadinOyuncular>(oyuncu);
	}
	
	@Override
	public Result addFutbolErkek(String oyuncuAdi,String oyuncuSoyAdi, String oyuncuUyruk,String oyuncuMevki,
			String oyuncuProfil,int oyuncuYasi, int oyuncuFormaNumarasi, double oyuncuBoyu) {
		Oyuncular oyuncu = new Oyuncular();
		oyuncu.setOyuncuAdi(oyuncuAdi);
		oyuncu.setOyuncuSoyAdi(oyuncuSoyAdi);
		oyuncu.setOyuncuUyruk(oyuncuUyruk);
		oyuncu.setOyuncuMevki(oyuncuMevki);
		oyuncu.setOyuncuProfil(oyuncuProfil);
		oyuncu.setOyuncuYasi(oyuncuYasi);
		oyuncu.setOyuncuFormaNumarasi(oyuncuFormaNumarasi);
		oyuncu.setOyuncuBoy(oyuncuBoyu);
		this.oyuncularDao.save(oyuncu);
		return new SuccessResult(true);
	}

	@Override
	public DataResult<List<BasketbolErkekOyuncular>> erkekBasketbolOyunculariGetir() {
		return new SuccessDataResult<List<BasketbolErkekOyuncular>>(this.basketbolErkekOyuncularDao.findAll());
	}

	@Override
	public DataResult<List<BasketbolKadinOyuncular>> kadinBasketbolOyunculariGetir() {
		return new SuccessDataResult<List<BasketbolKadinOyuncular>>(this.basketbolKadinOyuncularDao.findAll());
	}

	@Override
	public Result addBasketbolErkek(String oyuncuAdi, String oyuncuSoyAdi, String oyuncuUyruk, String oyuncuMevki,
			String oyuncuProfil, int oyuncuYasi, int oyuncuFormaNumarasi, double oyuncuBoyu) {
		BasketbolErkekOyuncular oyuncu = new BasketbolErkekOyuncular();
		oyuncu.setOyuncuAdi(oyuncuAdi);
		oyuncu.setOyuncuSoyAdi(oyuncuSoyAdi);
		oyuncu.setOyuncuUyruk(oyuncuUyruk);
		oyuncu.setOyuncuMevki(oyuncuMevki);
		oyuncu.setOyuncuProfil(oyuncuProfil);
		oyuncu.setOyuncuYasi(oyuncuYasi);
		oyuncu.setOyuncuFormaNumarasi(oyuncuFormaNumarasi);
		oyuncu.setOyuncuBoy(oyuncuBoyu);
		this.basketbolErkekOyuncularDao.save(oyuncu);
		return new SuccessResult(true,"Oyuncu ekleme başarılı");
	}

	@Override
	public Result addBasketbolKadin(String oyuncuAdi, String oyuncuSoyAdi, String oyuncuUyruk, String oyuncuMevki,
			String oyuncuProfil, int oyuncuYasi, int oyuncuFormaNumarasi, double oyuncuBoyu) {
		BasketbolKadinOyuncular oyuncu = new BasketbolKadinOyuncular();
		oyuncu.setOyuncuAdi(oyuncuAdi);
		oyuncu.setOyuncuSoyAdi(oyuncuSoyAdi);
		oyuncu.setOyuncuUyruk(oyuncuUyruk);
		oyuncu.setOyuncuMevki(oyuncuMevki);
		oyuncu.setOyuncuProfil(oyuncuProfil);
		oyuncu.setOyuncuYasi(oyuncuYasi);
		oyuncu.setOyuncuFormaNumarasi(oyuncuFormaNumarasi);
		oyuncu.setOyuncuBoy(oyuncuBoyu);
		this.basketbolKadinOyuncularDao.save(oyuncu);
		return new SuccessResult(true,"Oyuncu ekleme başarılı");
	}

	@Override
	public DataResult<List<VoleybolErkekOyuncular>> erkekVoleybolOyunculariGetir() {
		return new SuccessDataResult<List<VoleybolErkekOyuncular>>(this.voleybolErkekOyuncularDao.findAll());
	}

	@Override
	public DataResult<List<VoleybolKadinOyuncular>> kadinVoleybolOyunculariGetir() {
		return new SuccessDataResult<List<VoleybolKadinOyuncular>>(this.voleybolKadinOyuncularDao.findAll());
	}

	@Override
	public Result addVoleybolErkek(String oyuncuAdi, String oyuncuSoyAdi, String oyuncuUyruk, String oyuncuMevki,
			String oyuncuProfil, int oyuncuYasi, int oyuncuFormaNumarasi, double oyuncuBoyu) {
		VoleybolErkekOyuncular oyuncu = new VoleybolErkekOyuncular();
		oyuncu.setOyuncuAdi(oyuncuAdi);
		oyuncu.setOyuncuSoyAdi(oyuncuSoyAdi);
		oyuncu.setOyuncuUyruk(oyuncuUyruk);
		oyuncu.setOyuncuMevki(oyuncuMevki);
		oyuncu.setOyuncuProfil(oyuncuProfil);
		oyuncu.setOyuncuYasi(oyuncuYasi);
		oyuncu.setOyuncuFormaNumarasi(oyuncuFormaNumarasi);
		oyuncu.setOyuncuBoy(oyuncuBoyu);
		this.voleybolErkekOyuncularDao.save(oyuncu);
		return new SuccessResult(true,"Oyuncu ekleme başarılı");
	}

	@Override
	public Result addVoleybolKadin(String oyuncuAdi, String oyuncuSoyAdi, String oyuncuUyruk, String oyuncuMevki,
			String oyuncuProfil, int oyuncuYasi, int oyuncuFormaNumarasi, double oyuncuBoyu) {
		VoleybolKadinOyuncular oyuncu = new VoleybolKadinOyuncular();
		oyuncu.setOyuncuAdi(oyuncuAdi);
		oyuncu.setOyuncuSoyAdi(oyuncuSoyAdi);
		oyuncu.setOyuncuUyruk(oyuncuUyruk);
		oyuncu.setOyuncuMevki(oyuncuMevki);
		oyuncu.setOyuncuProfil(oyuncuProfil);
		oyuncu.setOyuncuYasi(oyuncuYasi);
		oyuncu.setOyuncuFormaNumarasi(oyuncuFormaNumarasi);
		oyuncu.setOyuncuBoy(oyuncuBoyu);
		this.voleybolKadinOyuncularDao.save(oyuncu);
		return new SuccessResult(true,"Oyuncu ekleme başarılı");
	}
	
}

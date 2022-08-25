package com.kanaryahaber.abdlkdrkya.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kanaryahaber.abdlkdrkya.business.abstracts.PuanDurumuService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessResult;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.BasketbolErkekPuanDurumuDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.BasketbolKadinPuanDurumuDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.PuanDurumuDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.VoleybolErkekPuanDurumuDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.VoleybolKadinPuanDurumuDao;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekPuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinPuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.PuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolErkekPuanDurumu;
import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolKadinPuanDurumu;

@Service
public class PuanDurumuManager implements PuanDurumuService{

	private PuanDurumuDao puanDurumuDao;
	private BasketbolKadinPuanDurumuDao basketbolKadinPuanDurumuDao;
	private BasketbolErkekPuanDurumuDao basketbolErkekPuanDurumuDao;
	private VoleybolKadinPuanDurumuDao voleybolKadinPuanDurumuDao;
	private VoleybolErkekPuanDurumuDao voleybolErkekPuanDurumuDao;
	
	@Autowired
	public PuanDurumuManager(PuanDurumuDao puanDurumuDao,BasketbolKadinPuanDurumuDao basketbolKadinPuanDurumuDao,
			BasketbolErkekPuanDurumuDao basketbolErkekPuanDurumuDao,VoleybolKadinPuanDurumuDao voleybolKadinPuanDurumuDao,
			 VoleybolErkekPuanDurumuDao voleybolErkekPuanDurumuDao) {
		super();
		this.puanDurumuDao = puanDurumuDao;
		this.basketbolKadinPuanDurumuDao = basketbolKadinPuanDurumuDao;
		this.basketbolErkekPuanDurumuDao = basketbolErkekPuanDurumuDao;
		this.voleybolKadinPuanDurumuDao = voleybolKadinPuanDurumuDao;
		this.voleybolErkekPuanDurumuDao = voleybolErkekPuanDurumuDao;
	}
	
	@Override
	public Result updatePuanDurumu(int takimId,int galibiyet, int beraberlik, int maglubiyet, int atilanGol, int yenilenGol) {
		PuanDurumu takim = this.puanDurumuDao.getById(takimId);
		int oynananMac = galibiyet + beraberlik + maglubiyet;
		takim.setOynananMac(oynananMac);
		takim.setGalibiyet(galibiyet);
		takim.setBeraberlik(beraberlik);
		takim.setMaglubiyet(maglubiyet);
		takim.setAtilanGol(atilanGol);
		takim.setYenilenGol(yenilenGol);
		int averaj = atilanGol-yenilenGol;
		takim.setAveraj(averaj);
		int puan = 3*(galibiyet)+1*(beraberlik);
		takim.setPuan(puan);
		this.puanDurumuDao.save(takim);
		return new SuccessResult(true,"Puan güncellendi");
	}

	@Override
	public DataResult<List<PuanDurumu>> getAllSorted() {
		Sort sort = Sort.by(Sort.Order.desc("puan"),Sort.Order.desc("averaj"),
				Sort.Order.desc("atilanGol"),Sort.Order.asc("takim"));
		return new SuccessDataResult<List<PuanDurumu>>(this.puanDurumuDao.findAll(sort),"Data Sıralandı");
	}

	@Override
	public Result updateBasketbolErkekPuanDurumu(int takimId, int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi) {
		BasketbolErkekPuanDurumu takim = this.basketbolErkekPuanDurumuDao.getById(takimId);
		int oynananMac = galibiyet + maglubiyet;
		takim.setOynananMac(oynananMac);
		takim.setGalibiyet(galibiyet);
		takim.setMaglubiyet(maglubiyet);
		takim.setAtilanSayi(atilanSayi);
		takim.setYenilenSayi(yenilenSayi);
		int averaj = atilanSayi-yenilenSayi;
		takim.setAveraj(averaj);
		int puan = 2*(galibiyet)+1*(maglubiyet);
		takim.setPuan(puan);
		this.basketbolErkekPuanDurumuDao.save(takim);
		return new SuccessResult(true,"Puan güncellendi");
	}

	@Override
	public DataResult<List<BasketbolErkekPuanDurumu>> getAllSortedBasketbolErkek() {
		Sort sort = Sort.by(Sort.Order.desc("puan"),Sort.Order.desc("averaj"),
				Sort.Order.desc("atilanSayi"),Sort.Order.asc("takim"));
		return new SuccessDataResult<List<BasketbolErkekPuanDurumu>>(this.basketbolErkekPuanDurumuDao.findAll(sort),"Data Sıralandı");
	}

	@Override
	public Result updateBasketbolKadinPuanDurumu(int takimId, int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi) {
		BasketbolKadinPuanDurumu takim = this.basketbolKadinPuanDurumuDao.getById(takimId);
		int oynananMac = galibiyet + maglubiyet;
		takim.setOynananMac(oynananMac);
		takim.setGalibiyet(galibiyet);
		takim.setMaglubiyet(maglubiyet);
		takim.setAtilanSayi(atilanSayi);
		takim.setYenilenSayi(yenilenSayi);
		int averaj = atilanSayi-yenilenSayi;
		takim.setAveraj(averaj);
		int puan = 2*(galibiyet)+1*(maglubiyet);
		takim.setPuan(puan);
		this.basketbolKadinPuanDurumuDao.save(takim);
		return new SuccessResult(true,"Puan güncellendi");
	}

	@Override
	public DataResult<List<BasketbolKadinPuanDurumu>> getAllSortedBasketbolKadin() {
		Sort sort = Sort.by(Sort.Order.desc("puan"),Sort.Order.desc("averaj"),
				Sort.Order.desc("atilanSayi"),Sort.Order.asc("takim"));
		return new SuccessDataResult<List<BasketbolKadinPuanDurumu>>(this.basketbolKadinPuanDurumuDao.findAll(sort),"Data Sıralandı");
	}

	@Override
	public Result addPuanDurumu(String takimAdi,int galibiyet, int beraberlik, int maglubiyet, int atilanGol, int yenilenGol) {
		PuanDurumu takim = new PuanDurumu();
		int oynananMac = galibiyet + beraberlik + maglubiyet;
		takim.setTakim(takimAdi);
		takim.setOynananMac(oynananMac);
		takim.setGalibiyet(galibiyet);
		takim.setBeraberlik(beraberlik);
		takim.setMaglubiyet(maglubiyet);
		takim.setAtilanGol(atilanGol);
		takim.setYenilenGol(yenilenGol);
		int averaj = atilanGol-yenilenGol;
		takim.setAveraj(averaj);
		int puan = 3*(galibiyet)+1*(beraberlik);
		takim.setPuan(puan);
		this.puanDurumuDao.save(takim);
		return new SuccessResult(true,"Puan güncellendi");
	}

	@Override
	public Result addPuanDurumuBasketbolErkek(String takimAdi,int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi) {
		BasketbolErkekPuanDurumu takim = new BasketbolErkekPuanDurumu();
		int oynananMac = galibiyet + maglubiyet;
		takim.setTakim(takimAdi);
		takim.setOynananMac(oynananMac);
		takim.setGalibiyet(galibiyet);
		takim.setMaglubiyet(maglubiyet);
		takim.setAtilanSayi(atilanSayi);
		takim.setYenilenSayi(yenilenSayi);
		int averaj = atilanSayi-yenilenSayi;
		takim.setAveraj(averaj);
		int puan = 2*(galibiyet)+1*(maglubiyet);
		takim.setPuan(puan);
		this.basketbolErkekPuanDurumuDao.save(takim);
		return new SuccessResult(true,"Puan güncellendi");
	}

	@Override
	public Result addPuanDurumuBasketbolKadin(String takimAdi,int galibiyet, int maglubiyet, int atilanSayi, int yenilenSayi) {
		BasketbolKadinPuanDurumu takim = new BasketbolKadinPuanDurumu();
		int oynananMac = galibiyet + maglubiyet;
		takim.setTakim(takimAdi);
		takim.setOynananMac(oynananMac);
		takim.setGalibiyet(galibiyet);
		takim.setMaglubiyet(maglubiyet);
		takim.setAtilanSayi(atilanSayi);
		takim.setYenilenSayi(yenilenSayi);
		int averaj = atilanSayi-yenilenSayi;
		takim.setAveraj(averaj);
		int puan = 2*(galibiyet)+1*(maglubiyet);
		takim.setPuan(puan);
		this.basketbolKadinPuanDurumuDao.save(takim);
		return new SuccessResult(true,"Puan güncellendi");
	}

	@Override
	public Result addPuanDurumuVoleybolKadin(String takimAdi, int galibiyet, int maglubiyet, int atilanSayi,
			int yenilenSayi, int aldigiSet, int verdigiSet,int puan) {
		VoleybolKadinPuanDurumu takim = new VoleybolKadinPuanDurumu();
		int oynananMac = galibiyet + maglubiyet;
		takim.setAldigiSayi(atilanSayi);
		takim.setVerdigiSayi(yenilenSayi);
		takim.setAldigiSet(aldigiSet);
		takim.setVerdigiSet(verdigiSet);
		double setAveraj = (double)aldigiSet/verdigiSet;
		setAveraj = setAveraj*1000;
		setAveraj = Math.round(setAveraj);
		setAveraj = setAveraj/1000;
		takim.setSetAveraji(setAveraj);
		takim.setTakim(takimAdi);
		takim.setOynananMac(oynananMac);
		takim.setGalibiyet(galibiyet);
		takim.setMaglubiyet(maglubiyet);
		double averaj = (double)atilanSayi/yenilenSayi;
		averaj = averaj*1000;
		averaj = Math.round(averaj);
		averaj = averaj/1000;
		takim.setAveraj(averaj);
		takim.setPuan(puan);
		this.voleybolKadinPuanDurumuDao.save(takim);
		return new SuccessResult(true,"Puan güncellendi");
	}

	@Override
	public Result updateVoleybolKadinPuanDurumu(int takimId, int galibiyet, int maglubiyet, int atilanSayi,
			int yenilenSayi, int aldigiSet, int verdigiSet,int puan) {
		VoleybolKadinPuanDurumu takim = this.voleybolKadinPuanDurumuDao.getById(takimId);
		int oynananMac = galibiyet + maglubiyet;
		takim.setAldigiSayi(atilanSayi);
		takim.setVerdigiSayi(yenilenSayi);
		takim.setAldigiSet(aldigiSet);
		takim.setVerdigiSet(verdigiSet);
		double setAveraj = (double)aldigiSet/verdigiSet;
		setAveraj = setAveraj*1000;
		setAveraj = Math.round(setAveraj);
		setAveraj = setAveraj/1000;
		takim.setSetAveraji(setAveraj);
		takim.setOynananMac(oynananMac);
		takim.setGalibiyet(galibiyet);
		takim.setMaglubiyet(maglubiyet);
		double averaj = (double)atilanSayi/yenilenSayi;
		averaj = averaj*1000;
		averaj = Math.round(averaj);
		averaj = averaj/1000;
		takim.setAveraj(averaj);
		takim.setPuan(puan);
		this.voleybolKadinPuanDurumuDao.save(takim);
		return new SuccessResult(true,"Puan güncellendi");
	}

	@Override
	public DataResult<List<VoleybolKadinPuanDurumu>> getAllSortedVoleybolKadin() {
		Sort sort = Sort.by(Sort.Order.desc("galibiyet"),Sort.Order.desc("puan"),
				Sort.Order.desc("setAveraji"),Sort.Order.asc("averaj"));
		return new SuccessDataResult<List<VoleybolKadinPuanDurumu>>(this.voleybolKadinPuanDurumuDao.findAll(sort),"Data Sıralandı");
	}
	@Override
	public Result addPuanDurumuVoleybolErkek(String takimAdi, int galibiyet, int maglubiyet, int atilanSayi,
			int yenilenSayi, int aldigiSet, int verdigiSet,int puan) {
		VoleybolErkekPuanDurumu takim = new VoleybolErkekPuanDurumu();
		int oynananMac = galibiyet + maglubiyet;
		takim.setAldigiSayi(atilanSayi);
		takim.setVerdigiSayi(yenilenSayi);
		takim.setAldigiSet(aldigiSet);
		takim.setVerdigiSet(verdigiSet);
		double setAveraj = (double)aldigiSet/verdigiSet;
		setAveraj = setAveraj*1000;
		setAveraj = Math.round(setAveraj);
		setAveraj = setAveraj/1000;
		takim.setSetAveraji(setAveraj);
		takim.setTakim(takimAdi);
		takim.setOynananMac(oynananMac);
		takim.setGalibiyet(galibiyet);
		takim.setMaglubiyet(maglubiyet);
		double averaj = (double)atilanSayi/yenilenSayi;
		averaj = averaj*1000;
		averaj = Math.round(averaj);
		averaj = averaj/1000;
		takim.setAveraj(averaj);
		takim.setPuan(puan);
		this.voleybolErkekPuanDurumuDao.save(takim);
		return new SuccessResult(true,"Puan güncellendi");
	}

	@Override
	public Result updateVoleybolErkekPuanDurumu(int takimId, int galibiyet, int maglubiyet, int atilanSayi,
			int yenilenSayi, int aldigiSet, int verdigiSet,int puan) {
		VoleybolErkekPuanDurumu takim = this.voleybolErkekPuanDurumuDao.getById(takimId);
		int oynananMac = galibiyet + maglubiyet;
		takim.setAldigiSayi(atilanSayi);
		takim.setVerdigiSayi(yenilenSayi);
		takim.setAldigiSet(aldigiSet);
		takim.setVerdigiSet(verdigiSet);
		double setAveraj = (double)aldigiSet/verdigiSet;
		setAveraj = setAveraj*1000;
		setAveraj = Math.round(setAveraj);
		setAveraj = setAveraj/1000;
		takim.setSetAveraji(setAveraj);
		takim.setOynananMac(oynananMac);
		takim.setGalibiyet(galibiyet);
		takim.setMaglubiyet(maglubiyet);
		double averaj = (double)atilanSayi/yenilenSayi;
		averaj = averaj*1000;
		averaj = Math.round(averaj);
		averaj = averaj/1000;
		takim.setAveraj(averaj);
		takim.setPuan(puan);
		this.voleybolErkekPuanDurumuDao.save(takim);
		return new SuccessResult(true,"Puan güncellendi");
	}

	@Override
	public DataResult<List<VoleybolErkekPuanDurumu>> getAllSortedVoleybolErkek() {
		Sort sort = Sort.by(Sort.Order.desc("galibiyet"),Sort.Order.desc("puan"),
				Sort.Order.desc("setAveraji"),Sort.Order.asc("averaj"));
		return new SuccessDataResult<List<VoleybolErkekPuanDurumu>>(this.voleybolErkekPuanDurumuDao.findAll(sort),"Data Sıralandı");
	}
}

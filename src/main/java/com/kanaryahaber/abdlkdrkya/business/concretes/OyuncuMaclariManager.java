package com.kanaryahaber.abdlkdrkya.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kanaryahaber.abdlkdrkya.business.abstracts.OyuncuMaclariService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessResult;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.BasketbolErkekOyuncuMaclariDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.BasketbolErkekOyuncularDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.BasketbolKadinOyuncuMaclariDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.BasketbolKadinOyuncularDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.FiksturDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.OyuncuMaclariDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.OyuncularDao;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekOyuncuMaclari;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinOyuncuMaclari;
import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinOyuncular;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Fikstur;
import com.kanaryahaber.abdlkdrkya.entities.concretes.OyuncuMaclari;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Oyuncular;

@Service
public class OyuncuMaclariManager implements OyuncuMaclariService{

	private OyuncuMaclariDao oyuncuMaclariDao;
	private OyuncularDao oyuncularDao;
	private FiksturDao fiksturDao;
	
	private BasketbolErkekOyuncuMaclariDao basketbolErkekOyuncuMaclariDao;
	private BasketbolErkekOyuncularDao basketbolErkekOyuncularDao;
	
	private BasketbolKadinOyuncuMaclariDao basketbolKadinOyuncuMaclariDao;
	private BasketbolKadinOyuncularDao basketbolKadinOyuncularDao;
	
	@Autowired
	public OyuncuMaclariManager(OyuncuMaclariDao oyuncuMaclariDao,OyuncularDao oyuncularDao, FiksturDao fiksturDao,
			BasketbolErkekOyuncuMaclariDao basketbolErkekOyuncuMaclariDao,BasketbolErkekOyuncularDao basketbolErkekOyuncularDao,
			BasketbolKadinOyuncuMaclariDao basketbolKadinOyuncuMaclariDao,BasketbolKadinOyuncularDao basketbolKadinOyuncularDao) {
		super();
		this.oyuncuMaclariDao = oyuncuMaclariDao;
		this.oyuncularDao = oyuncularDao;
		this.fiksturDao = fiksturDao;
		this.basketbolErkekOyuncuMaclariDao = basketbolErkekOyuncuMaclariDao;
		this.basketbolErkekOyuncularDao = basketbolErkekOyuncularDao;	
		this.basketbolKadinOyuncuMaclariDao = basketbolKadinOyuncuMaclariDao;
		this.basketbolKadinOyuncularDao = basketbolKadinOyuncularDao;
	}
	
	@Override
	public DataResult<List<OyuncuMaclari>> oyuncuMaclariGetirByOyuncuId(int oyuncuId) {
		Sort sort = Sort.by(Sort.Direction.ASC,"mac_fiksturTarih");
		return new SuccessDataResult<List<OyuncuMaclari>>(this.oyuncuMaclariDao.getByOyuncu_OyuncuId(oyuncuId,sort));
	}

	@Override
	public Result add(int macOyuncuId, boolean macIlk11,
			int macDakika,int macSariKart,int macKirmiziKart,int macGol,
			int macAsist,int macId) {
		Oyuncular oyuncu = oyuncularDao.getByOyuncuId(macOyuncuId);
		Fikstur mac = fiksturDao.getByFiksturId(macId);
		OyuncuMaclari istatistikler = new OyuncuMaclari();
		istatistikler.setOyuncu(oyuncu);
		istatistikler.setMacAsist(macAsist);
		istatistikler.setMacDakika(macDakika);
		istatistikler.setMacGol(macGol);
		istatistikler.setMacIlk11(macIlk11);
		istatistikler.setMacKirmiziKart(macKirmiziKart);
		istatistikler.setMacSariKart(macSariKart);
		istatistikler.setMac(mac);
		this.oyuncuMaclariDao.save(istatistikler);
		return new SuccessResult(true,"Başarılı");
	}
	
	@Override
	public Result futbolcuGuncelle(int macOyuncuId, boolean macIlk11, int macDakika, int macSariKart, int macKirmiziKart, int macGol,
			int macAsist, int macId) {
		Oyuncular oyuncu = this.oyuncularDao.getByOyuncuId(macOyuncuId);
		if(oyuncu == null) {
			return new ErrorResult(false,"Oyuncu bulunamadı!");
		}
		Fikstur mac = this.fiksturDao.getByFiksturId(macId);
		if(mac == null) {
			return new ErrorResult(false,"Maç bulunamadı");
		}
		OyuncuMaclari istatistikler = this.oyuncuMaclariDao.getByOyuncu_OyuncuIdAndMac_FiksturId(macOyuncuId, macId);
		if(istatistikler == null) {
			return new ErrorResult(false,"İstatistik bulunamadı");
		}
		istatistikler.setMac(mac);
		istatistikler.setOyuncu(oyuncu);
		istatistikler.setMacIlk11(macIlk11);
		istatistikler.setMacDakika(macDakika);
		istatistikler.setMacSariKart(macSariKart);
		istatistikler.setMacKirmiziKart(macKirmiziKart);
		istatistikler.setMacGol(macGol);
		istatistikler.setMacAsist(macAsist);
		this.oyuncuMaclariDao.save(istatistikler);
		return new SuccessResult(true,"Başarıyla güncellendi");
		
	}

	@Override
	public DataResult<List<OyuncuMaclari>> getAll() {
		return new SuccessDataResult<List<OyuncuMaclari>>(this.oyuncuMaclariDao.findAll());
		}

	@Override
	public DataResult<List<OyuncuMaclari>> oyuncuMaclariGetirByFiksturId(int fiksturId) {
		Sort sort = Sort.by(Sort.Direction.ASC,"mac_fiksturTarih");
		return new SuccessDataResult<List<OyuncuMaclari>>(this.oyuncuMaclariDao.getByMac_FiksturId(fiksturId,sort));
	}

	@Override
	public DataResult<List<BasketbolErkekOyuncuMaclari>> basketbolErkekOyuncuMaclariGetirByOyuncuId(int oyuncuId) {
		Sort sort = Sort.by(Sort.Direction.ASC,"mac_fiksturTarih");
		return new SuccessDataResult<List<BasketbolErkekOyuncuMaclari>>(this.basketbolErkekOyuncuMaclariDao.getByOyuncu_OyuncuId(oyuncuId,sort));
	}

	@Override
	public DataResult<List<BasketbolErkekOyuncuMaclari>> basketbolErkekOyuncuMaclariGetirByFiksturId(int fiksturId) {
		Sort sort = Sort.by(Sort.Direction.ASC,"mac_fiksturTarih");
		return new SuccessDataResult<List<BasketbolErkekOyuncuMaclari>>(this.basketbolErkekOyuncuMaclariDao.getByMac_FiksturId(fiksturId,sort));
	}

	@Override
	public Result addBasketbolErkekOyuncuMaci(int macOyuncuId, int macAsist, int macBlock, int macHucumRibaund, int macSavunmaRibaund,int macSayi,int macTopCalma,
			int macTopKaybi,int macId) {
		BasketbolErkekOyuncular oyuncu = basketbolErkekOyuncularDao.getByOyuncuId(macOyuncuId);
		Fikstur mac = fiksturDao.getByFiksturId(macId);
		BasketbolErkekOyuncuMaclari istatistikler = new BasketbolErkekOyuncuMaclari();
		istatistikler.setOyuncu(oyuncu);
		istatistikler.setMacAsist(macAsist);
		istatistikler.setMacBlok(macBlock);
		istatistikler.setMacHucumRibaund(macHucumRibaund);
		int macRibaund = macHucumRibaund + macSavunmaRibaund;
		istatistikler.setMacRibaund(macRibaund);
		istatistikler.setMacSavunmaRibaund(macSavunmaRibaund);
		istatistikler.setMacSayi(macSayi);
		istatistikler.setMacTopCalma(macTopCalma);
		istatistikler.setMacTopKaybi(macTopKaybi);
		istatistikler.setMac(mac);
		this.basketbolErkekOyuncuMaclariDao.save(istatistikler);
		return new SuccessResult(true,"Başarılı");
	}
	
	@Override
	public Result guncelleBasketbolErkekOyuncuMaci(int macOyuncuId, int macAsist, int macBlock, int macHucumRibaund, int macSavunmaRibaund,int macSayi,int macTopCalma,
			int macTopKaybi,int macId) {
		BasketbolErkekOyuncular oyuncu = basketbolErkekOyuncularDao.getByOyuncuId(macOyuncuId);
		if(oyuncu == null) {
			return new ErrorResult(false,"Oyuncu bulunamadı");
		}
		Fikstur mac = fiksturDao.getByFiksturId(macId);
		if(mac == null) {
			return new ErrorResult(false,"Maç bulunamadı");
		}
		BasketbolErkekOyuncuMaclari istatistik = this.basketbolErkekOyuncuMaclariDao.getByOyuncu_OyuncuIdAndMac_FiksturId(macOyuncuId, macId);
		if(istatistik == null) {
			return new ErrorResult(false,"İstatistik bulunamadı");
		}
		istatistik.setOyuncu(oyuncu);
		istatistik.setMacAsist(macAsist);
		istatistik.setMacBlok(macBlock);
		istatistik.setMacHucumRibaund(macHucumRibaund);
		int macRibaund = macHucumRibaund + macSavunmaRibaund;
		istatistik.setMacRibaund(macRibaund);
		istatistik.setMacSavunmaRibaund(macSavunmaRibaund);
		istatistik.setMacSayi(macSayi);
		istatistik.setMacTopCalma(macTopCalma);
		istatistik.setMacTopKaybi(macTopKaybi);
		istatistik.setMac(mac);
		this.basketbolErkekOyuncuMaclariDao.save(istatistik);
		return new SuccessResult(true,"Başarılı");
	}

	@Override
	public DataResult<List<BasketbolErkekOyuncuMaclari>> getAllBasketbolErkekOyuncuMaclari() {
		return new SuccessDataResult<List<BasketbolErkekOyuncuMaclari>>(this.basketbolErkekOyuncuMaclariDao.findAll());
	}

	@Override
	public DataResult<List<BasketbolKadinOyuncuMaclari>> basketbolKadinOyuncuMaclariGetirByOyuncuId(int oyuncuId) {
		Sort sort = Sort.by(Sort.Direction.ASC,"mac_fiksturTarih");
		return new SuccessDataResult<List<BasketbolKadinOyuncuMaclari>>(this.basketbolKadinOyuncuMaclariDao.getByOyuncu_OyuncuId(oyuncuId,sort));
	}

	@Override
	public DataResult<List<BasketbolKadinOyuncuMaclari>> basketbolKadinOyuncuMaclariGetirByFiksturId(int fiksturId) {
		Sort sort = Sort.by(Sort.Direction.ASC,"mac_fiksturTarih");
		return new SuccessDataResult<List<BasketbolKadinOyuncuMaclari>>(this.basketbolKadinOyuncuMaclariDao.getByMac_FiksturId(fiksturId,sort));
	}

	@Override
	public Result addBasketbolKadinOyuncuMaci(int macOyuncuId, int macAsist, int macBlock, int macHucumRibaund, int macSavunmaRibaund,int macSayi,int macTopCalma,
			int macTopKaybi,int macId) {
		BasketbolKadinOyuncular oyuncu = basketbolKadinOyuncularDao.getByOyuncuId(macOyuncuId);
		Fikstur mac = fiksturDao.getByFiksturId(macId);
		BasketbolKadinOyuncuMaclari istatistikler = new BasketbolKadinOyuncuMaclari();
		istatistikler.setOyuncu(oyuncu);
		istatistikler.setMacAsist(macAsist);
		istatistikler.setMacBlok(macBlock);
		int macRibaund = macHucumRibaund + macSavunmaRibaund;
		istatistikler.setMacHucumRibaund(macHucumRibaund);
		istatistikler.setMacRibaund(macRibaund);
		istatistikler.setMacSavunmaRibaund(macSavunmaRibaund);
		istatistikler.setMacSayi(macSayi);
		istatistikler.setMacTopCalma(macTopCalma);
		istatistikler.setMacTopKaybi(macTopKaybi);
		istatistikler.setMac(mac);
		this.basketbolKadinOyuncuMaclariDao.save(istatistikler);
		return new SuccessResult(true,"Başarılı");
	}
	
	@Override
	public Result guncelleBasketbolKadinOyuncuMaci(int macOyuncuId, int macAsist, int macBlock, int macHucumRibaund, int macSavunmaRibaund,int macSayi,int macTopCalma,
			int macTopKaybi,int macId) {
		BasketbolKadinOyuncular oyuncu = basketbolKadinOyuncularDao.getByOyuncuId(macOyuncuId);
		if(oyuncu == null) {
			return new ErrorResult(false,"Oyuncu bulunamadı");
		}
		Fikstur mac = fiksturDao.getByFiksturId(macId);
		if(mac == null) {
			return new ErrorResult(false,"Maç bulunamadı");
		}
		BasketbolKadinOyuncuMaclari istatistik = this.basketbolKadinOyuncuMaclariDao.getByOyuncu_OyuncuIdAndMac_FiksturId(macOyuncuId, macId);
		if(istatistik == null) {
			return new ErrorResult(false,"İstatistik bulunamadı");
		}
		istatistik.setOyuncu(oyuncu);
		istatistik.setMacAsist(macAsist);
		istatistik.setMacBlok(macBlock);
		istatistik.setMacHucumRibaund(macHucumRibaund);
		int macRibaund = macHucumRibaund + macSavunmaRibaund;
		istatistik.setMacRibaund(macRibaund);
		istatistik.setMacSavunmaRibaund(macSavunmaRibaund);
		istatistik.setMacSayi(macSayi);
		istatistik.setMacTopCalma(macTopCalma);
		istatistik.setMacTopKaybi(macTopKaybi);
		istatistik.setMac(mac);
		this.basketbolKadinOyuncuMaclariDao.save(istatistik);
		return new SuccessResult(true,"Başarılı");
	}

	@Override
	public DataResult<List<BasketbolKadinOyuncuMaclari>> getAllBasketbolKadinOyuncuMaclari() {
		return new SuccessDataResult<List<BasketbolKadinOyuncuMaclari>>(this.basketbolKadinOyuncuMaclariDao.findAll());
	}

	
}

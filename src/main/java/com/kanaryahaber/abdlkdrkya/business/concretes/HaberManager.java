package com.kanaryahaber.abdlkdrkya.business.concretes;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kanaryahaber.abdlkdrkya.business.abstracts.HaberService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessResult;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.HaberlerBaseDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.HaberlerDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.KategoriCinsiyetDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.KategoriDao;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Haberler;
import com.kanaryahaber.abdlkdrkya.entities.concretes.HaberlerBase;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Kategori;
import com.kanaryahaber.abdlkdrkya.entities.concretes.KategoriCinsiyet;

@Service
public class HaberManager implements HaberService {
	private HaberlerDao haberDao;
	private KategoriDao kategoriDao;
	private KategoriCinsiyetDao kategoriCinsiyetDao;
	private HaberlerBaseDao haberlerBaseDao;

	@Autowired
	public HaberManager(HaberlerDao haberDao, KategoriDao kategoriDao, KategoriCinsiyetDao kategoriCinsiyetDao, HaberlerBaseDao haberlerBaseDao) {
		super();
		this.haberDao = haberDao;
		this.kategoriDao = kategoriDao;
		this.kategoriCinsiyetDao = kategoriCinsiyetDao;
		this.haberlerBaseDao = haberlerBaseDao;
	}

	@Override
	public DataResult<List<Haberler>> getAll() {
		return new SuccessDataResult<List<Haberler>>(this.haberDao.findAll());
	}

	@Override
	public DataResult<List<Haberler>> getSondakika() {
		int pageNo = 0;
		int pageSize = 10;
		Pageable page = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC,"haberTarih"));
		return new SuccessDataResult<List<Haberler>>(this.haberDao.findAll(page).getContent());
	}

	@Override
	public DataResult<List<Haberler>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "haberTarih");
		return new SuccessDataResult<List<Haberler>>(this.haberDao.findAll(sort), "Data sıralandı");
	}
	
	@Override
	public Result sosyalEtkilesim(int haberId, int etkilesimId) {
		Haberler haber = this.haberDao.getByHaberId(haberId);
		if(haber == null) {
			return new ErrorResult(false,"Haber bulunamadı");
		}
		if(etkilesimId == 1) {
			int like = haber.getHaberLike();
			like += 1;
			haber.setHaberLike(like);
		}
		if(etkilesimId == 2) {
			int dislike = haber.getHaberDislike();
			dislike += 1;
			haber.setHaberDislike(dislike);
		}
		if(etkilesimId == 4) {
			int hate = haber.getHaberHate();
			hate += 1;
			haber.setHaberHate(hate);
		}
		if(etkilesimId == 5) {
			int funny = haber.getHaberFunny();
			funny += 1;
			haber.setHaberFunny(funny);
		}
		if(etkilesimId > 5) {
			return new ErrorResult(false,"Geçersiz etkileşim");
		}
		this.haberDao.save(haber);		
		return new SuccessResult(true,"Etkileşim başarılı");
	}
	

	@Override
	public Result add(String haberBaslik, String haberIcerik, String haberKaynak, String haberAnasayfaResim,
			String haberEtiket1, String haberEtiket2, int haberKategoriId, int haberCinsiyetId) {

		Haberler yeniHaber = haberDao.getByHaberBaslik(haberBaslik);
		if (yeniHaber != null) {
			return new ErrorResult(false, "Haber başlığı daha önce girilmiş!");
		}
		Haberler haber = new Haberler();
		haber.setHaberBaslik(haberBaslik);
		haber.setHaberIcerik(haberIcerik);
		haber.setHaberKaynak(haberKaynak);
		haber.setHaberAnasayfaResim(haberAnasayfaResim);
		haber.setHaberEtiket1(haberEtiket1);
		haber.setHaberEtiket2(haberEtiket2);
		haber.setHaberLike(0);
		haber.setHaberDislike(0);
		haber.setHaberFunny(0);
		haber.setHaberHate(0);
		haber.setHaberTarih(ZonedDateTime.now());
		Kategori kategori = this.kategoriDao.getByKategoriId(haberKategoriId);
		if (kategori == null) {
			return new ErrorResult(false, "Kategori bulunamadı!");
		}
		KategoriCinsiyet kategoriCinsiyet = this.kategoriCinsiyetDao.getByCinsiyetId(haberCinsiyetId);
		if (kategoriCinsiyet == null) {
			return new ErrorResult(false, "Kategori Cinsiyet bulunamadı!");
		}
		haber.setHaberKategori(kategori);
		haber.setHaberCinsiyet(kategoriCinsiyet);
		this.haberDao.save(haber);
		return new SuccessResult(true, "Haber eklendi");

	}

	@Override
	public DataResult<Haberler> getByHaberBaslik(String haberBaslik) {
		HaberlerBase haber = haberlerBaseDao.getByHaberBaslik(haberBaslik);
		if (haber == null) {
			return new ErrorDataResult<>(false, "Haber Bulunamadı");
		}
		return new SuccessDataResult<Haberler>(this.haberDao.getByHaberBaslik(haberBaslik), "Data listelendi");
	}

	@Override
	public DataResult<Haberler> getByHaberBaslikAndKategori(String haberBaslik, int categoryId) {
		return new SuccessDataResult<Haberler>(
				this.haberDao.getByHaberBaslikAndHaberKategori_KategoriId(haberBaslik, categoryId), "Data listelendi");
	}

	@Override
	public DataResult<List<Haberler>> getByHaberBaslikOrKategori(String haberBaslik, int categoryId) {
		return new SuccessDataResult<List<Haberler>>(
				this.haberDao.getByHaberBaslikOrHaberKategori_KategoriId(haberBaslik, categoryId), "Data listelendi");
	}

	@Override
	public DataResult<List<Haberler>> getByHaberBaslikContains(String haberBaslik) {
		return new SuccessDataResult<List<Haberler>>(this.haberDao.getByHaberBaslikContains(haberBaslik),
				"Data listelendi");
	}

	@Override
	public DataResult<List<Haberler>> getByHaberBaslikStartsWith(String haberBaslik) {
		return new SuccessDataResult<List<Haberler>>(this.haberDao.getByHaberBaslikStartsWith(haberBaslik),
				"Data listelendi");
	}

	@Override
	public DataResult<List<Haberler>> getByBaslikAndKategori(String haberBaslik, int categoryId) {
		return new SuccessDataResult<List<Haberler>>(this.haberDao.getByBaslikAndHaberKategori(haberBaslik, categoryId),
				"Data listelendi");
	}


	@Override
	public DataResult<List<Haberler>> getByHaberKategori_KategoriId(int categoryId) {
		Sort sort = Sort.by(Sort.Order.desc("haberTarih"));
		return new SuccessDataResult<List<Haberler>>(this.haberDao.getByHaberKategori_KategoriId(categoryId,sort));
	}

	@Override
	public DataResult<Haberler> getByHaberId(int haberId) {
		Haberler haber = haberDao.getByHaberId(haberId);
		if (haber == null) {
			return new ErrorDataResult<Haberler>(false, "Haber Bulunamadı!");
		}
		return new SuccessDataResult<Haberler>(this.haberDao.getByHaberId(haberId), "Data listelendi");
	}
	
	@Override
	public DataResult<List<Haberler>> getByHaberKategori_KategoriIdSorted(int categoryId) {
		int pageNo = 0;
		int pageSize = 10;
		Pageable page = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "haberTarih"));
		return new SuccessDataResult<List<Haberler>>(this.haberDao.getByHaberKategori_KategoriId(categoryId, page));
	}

	@Override
	public DataResult<List<Haberler>> getByHaberKategori_KategoriIdAndHaberCinsiyet_CinsiyetId(int categoryId,
			int cinsiyetId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "haberTarih");
		return new SuccessDataResult<List<Haberler>>(
				this.haberDao.getByHaberCinsiyet_CinsiyetIdAndHaberKategori_KategoriId(cinsiyetId, categoryId,sort));
	}

	@Override
	public Result guncelle(int haberId,String haberBaslik, String haberIcerik, String haberKaynak, String haberAnasayfaResim,
			String haberEtiket1, String haberEtiket2, int haberKategoriId, int haberCinsiyetId) {
		Haberler haber = this.haberDao.getByHaberId(haberId);
		String a = String.valueOf(haberKategoriId);
		String b = String.valueOf(haberCinsiyetId);
		if(haber == null) {
			return new ErrorResult(false,"Haber bulunamadı");
		}
		if(haberBaslik.length() > 0) {
			haber.setHaberBaslik(haberBaslik);
		}
		if(haberIcerik.length() > 0) {
			haber.setHaberIcerik(haberIcerik);
		}
		if(haberKaynak.length() > 0) {
			haber.setHaberKaynak(haberKaynak);
		}
		if(haberAnasayfaResim.length() > 0) {
			haber.setHaberAnasayfaResim(haberAnasayfaResim);
		}
		if(haberEtiket1.length() > 0) {
			haber.setHaberEtiket1(haberEtiket1);
		}
		if(haberEtiket2.length() > 0) {
			haber.setHaberEtiket2(haberEtiket2);
		}
		if(a.length() > 0) {
			Kategori kategori = this.kategoriDao.getByKategoriId(haberKategoriId);
			if(kategori == null) {
				return new ErrorResult(false,"Kategori bulunamadı");
			}
			haber.setHaberKategori(kategori);
		}
		if(b.length() > 0) {
			KategoriCinsiyet cinsiyet = this.kategoriCinsiyetDao.getByCinsiyetId(haberCinsiyetId);
			
			if(cinsiyet == null) {
				return new ErrorResult(false,"Cinsiyet bulunamadı");
			}
			haber.setHaberCinsiyet(cinsiyet);
		}
		this.haberDao.save(haber);
		return new SuccessResult(true,"Güncelleme başarılı");
	}

}

package com.kanaryahaber.abdlkdrkya.business.abstracts;

import java.util.List;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Haberler;
public interface HaberService {
	DataResult<List<Haberler>> getAll();

	DataResult<List<Haberler>> getSondakika();

	DataResult<List<Haberler>> getAllSorted();

	Result add(String haberBaslik, String haberIcerik, String haberKaynak, String haberAnasayfaResim,
			String haberEtiket1, String haberEtiket2, int haberKategoriId, int haberCinsiyetId);

	Result guncelle(int haberId,String haberBaslik, String haberIcerik, String haberKaynak, String haberAnasayfaResim,
			String haberEtiket1, String haberEtiket2, int haberKategoriId, int haberCinsiyetId);
	
	Result sosyalEtkilesim(int haberId, int etkilesimId);

	DataResult<Haberler> getByHaberBaslik(String haberBaslik);

	DataResult<Haberler> getByHaberBaslikAndKategori(String haberBaslik, int categoryId);

	DataResult<List<Haberler>> getByHaberBaslikOrKategori(String haberBaslik, int categoryId);

	DataResult<List<Haberler>> getByHaberKategori_KategoriId(int categoryId);

	DataResult<List<Haberler>> getByHaberKategori_KategoriIdAndHaberCinsiyet_CinsiyetId(int categoryId, int cinsiyetId);

	DataResult<List<Haberler>> getByHaberKategori_KategoriIdSorted(int categoryId);

	DataResult<List<Haberler>> getByHaberBaslikContains(String haberBaslik);

	DataResult<List<Haberler>> getByHaberBaslikStartsWith(String haberBaslik);

	DataResult<Haberler> getByHaberId(int haberId);

	DataResult<List<Haberler>> getByBaslikAndKategori(String haberBaslik, int categoryId);


}

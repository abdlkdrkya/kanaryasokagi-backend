package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kanaryahaber.abdlkdrkya.entities.concretes.HaberlerBase;

public interface HaberlerBaseDao extends JpaRepository<HaberlerBase, Integer> {
	HaberlerBase getByHaberBaslik(String haberBaslik);

	HaberlerBase getByHaberId(int haberId);

	HaberlerBase getByHaberBaslikAndHaberKategori_KategoriId(String haberBaslik, int categoryId);

	List<HaberlerBase> getByHaberBaslikOrHaberKategori_KategoriId(String haberBaslik, int categoryId);

	List<HaberlerBase> getByHaberKategori_KategoriIdIn(List<Integer> categories);

	List<HaberlerBase> getByHaberBaslikContains(String haberBaslik);

	List<HaberlerBase> getByHaberKategori_KategoriId(int categoryId);
	
	List<HaberlerBase> getByHaberBaslikAndHaberKategori(String haberBaslik, int categoryId);

	List<HaberlerBase> getByHaberKategori_KategoriId(int categoryId, Pageable page);

	List<HaberlerBase> getByHaberBaslikStartsWith(String haberBaslik);

}

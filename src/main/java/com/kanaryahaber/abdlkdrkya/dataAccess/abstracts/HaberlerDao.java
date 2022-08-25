package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kanaryahaber.abdlkdrkya.entities.concretes.Haberler;


public interface HaberlerDao extends JpaRepository<Haberler, Integer>{
	Haberler getByHaberBaslik(String haberBaslik);
	
	Haberler getByHaberId(int haberId);
	
	Haberler getByHaberBaslikAndHaberKategori_KategoriId(String haberBaslik,int categoryId);
	
	List<Haberler> getByHaberBaslikOrHaberKategori_KategoriId(String haberBaslik,int categoryId);
	
	List<Haberler> getByHaberKategori_KategoriIdIn(List<Integer> categories);
	
	List<Haberler> getByHaberBaslikContains(String haberBaslik);
	
	List<Haberler> getByHaberKategori_KategoriId(int categoryId,Sort sort);
	
	List<Haberler> getByHaberCinsiyet_CinsiyetIdAndHaberKategori_KategoriId(int cinsiyetId,int categoryId,Sort sort);
	
	List<Haberler> getByHaberKategori_KategoriId(int categoryId,Pageable page);
	
	List<Haberler> getByHaberBaslikStartsWith(String haberBaslik);
	
	@Query("From Haberler where haberBaslik=:haberBaslik and haberKategori.kategoriId=:kategoriId")
	List<Haberler> getByBaslikAndHaberKategori(String haberBaslik,int kategoriId);
	
}

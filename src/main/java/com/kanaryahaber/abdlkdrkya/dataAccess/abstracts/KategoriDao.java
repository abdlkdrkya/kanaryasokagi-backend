package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.Kategori;

public interface KategoriDao extends JpaRepository<Kategori, Integer>{
	Kategori getByKategoriId(int kategoriId);
}

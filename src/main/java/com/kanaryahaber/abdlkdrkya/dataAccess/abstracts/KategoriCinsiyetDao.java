package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.KategoriCinsiyet;

public interface KategoriCinsiyetDao extends JpaRepository<KategoriCinsiyet, Integer>{

	KategoriCinsiyet getByCinsiyetId(int cinsiyetId);
}

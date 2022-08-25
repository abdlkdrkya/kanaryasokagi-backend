package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.PuanDurumu;

public interface PuanDurumuDao extends JpaRepository<PuanDurumu, Integer>{
	PuanDurumu getByPuanDurumuId(int takimId);
}

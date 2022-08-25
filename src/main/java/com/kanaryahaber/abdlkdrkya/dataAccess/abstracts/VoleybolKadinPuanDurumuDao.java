package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.VoleybolKadinPuanDurumu;

public interface VoleybolKadinPuanDurumuDao extends JpaRepository<VoleybolKadinPuanDurumu, Integer>{
	VoleybolKadinPuanDurumu getByPuanDurumuId(int takimId);
}

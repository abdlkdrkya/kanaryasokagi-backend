package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinPuanDurumu;

public interface BasketbolKadinPuanDurumuDao extends JpaRepository<BasketbolKadinPuanDurumu, Integer>{
	BasketbolKadinPuanDurumu getByPuanDurumuId(int takimId);
}

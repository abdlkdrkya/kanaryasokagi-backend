package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinOyuncuMaclari;

public interface BasketbolKadinOyuncuMaclariDao extends JpaRepository<BasketbolKadinOyuncuMaclari, Integer>{
	List<BasketbolKadinOyuncuMaclari> getByOyuncu_OyuncuId(int oyuncuId,Sort sort);
	List<BasketbolKadinOyuncuMaclari> getByMac_FiksturId(int fiksturId,Sort sort);
	BasketbolKadinOyuncuMaclari getByOyuncu_OyuncuIdAndMac_FiksturId(int oyuncuId, int fiksturId);
}

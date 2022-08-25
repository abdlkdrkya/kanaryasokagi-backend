package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekOyuncuMaclari;

public interface BasketbolErkekOyuncuMaclariDao extends JpaRepository<BasketbolErkekOyuncuMaclari, Integer>{
	
	List<BasketbolErkekOyuncuMaclari> getByOyuncu_OyuncuId(int oyuncuId,Sort sort);
	List<BasketbolErkekOyuncuMaclari> getByMac_FiksturId(int fiksturId,Sort sort);
	BasketbolErkekOyuncuMaclari getByOyuncu_OyuncuIdAndMac_FiksturId(int oyuncuId, int fiksturId);

}

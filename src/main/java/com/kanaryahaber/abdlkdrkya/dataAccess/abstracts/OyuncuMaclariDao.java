package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kanaryahaber.abdlkdrkya.entities.concretes.OyuncuMaclari;
import org.springframework.data.domain.Sort;

public interface OyuncuMaclariDao extends JpaRepository<OyuncuMaclari, Integer>{

	List<OyuncuMaclari> getByOyuncu_OyuncuId(int oyuncuId,Sort sort);
	List<OyuncuMaclari> getByMac_FiksturId(int fiksturId,Sort sort);
	OyuncuMaclari getByOyuncu_OyuncuIdAndMac_FiksturId(int oyuncuId, int fiksturId);
}

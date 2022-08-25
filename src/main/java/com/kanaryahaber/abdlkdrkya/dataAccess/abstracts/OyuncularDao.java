package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.Oyuncular;

public interface OyuncularDao extends JpaRepository<Oyuncular, Integer>{

	Oyuncular getByOyuncuId(int oyuncuId);
	
}

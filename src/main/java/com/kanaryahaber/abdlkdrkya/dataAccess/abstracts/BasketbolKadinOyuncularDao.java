package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolKadinOyuncular;


public interface BasketbolKadinOyuncularDao extends JpaRepository<BasketbolKadinOyuncular, Integer>{
	BasketbolKadinOyuncular getByOyuncuId(int oyuncuId);
}

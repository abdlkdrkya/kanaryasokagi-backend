package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.BasketbolErkekOyuncular;

public interface BasketbolErkekOyuncularDao extends JpaRepository<BasketbolErkekOyuncular, Integer>{
	BasketbolErkekOyuncular getByOyuncuId(int oyuncuId);
}
